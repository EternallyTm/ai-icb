package com.icb.chat.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.icb.chat.bo.ChatSessionBO;
import com.icb.chat.bo.SendMessageBO;
import com.icb.chat.bo.ReplyMessageBO;
import com.icb.chat.enums.MessageTypeEnum;
import com.icb.chat.enums.SenderTypeEnum;
import com.icb.chat.prompt.PromptManage;
import com.icb.chat.service.MessageService;
import com.icb.dal.entity.ChatMessages;
import com.icb.dal.entity.ChatSessions;
import com.icb.dal.mapper.ChatMessagesMapper;
import com.icb.dal.mapper.ChatSessionsMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.zhipuai.ZhiPuAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    private static final String SUMMARY_PROMPT = "对如下这段话进行摘要，摘要信息作为本次会话的标题，直接给出会话摘要结果，不要有多余的描述，信息为：";

    @Autowired
    private ChatSessionsMapper sessionsMapper;

    @Autowired
    private ChatMessagesMapper messagesMapper;

    @Autowired
    private ZhiPuAiChatModel zhiPuAiChatModel;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ReplyMessageBO sendMessage(SendMessageBO sendMessageBO) {
        String sessionId = sendMessageBO.getSessionId();
        ChatSessions chatSessions = sessionsMapper.selectById(sessionId);
        // 如果会话ID为空，则生成新的会话
        LocalDateTime now = LocalDateTime.now();
        if (Objects.isNull(chatSessions)) {
            // 调用大模型对content生成摘要，作为会话标题
            String summaryMessage = zhiPuAiChatModel.call(SUMMARY_PROMPT + sendMessageBO.getContent());
            ChatSessions newChatSessions = new ChatSessions();
            newChatSessions.setTitle(summaryMessage);
            newChatSessions.setCreatedAt(now);
            newChatSessions.setUserId(sendMessageBO.getSenderId());
            sessionsMapper.insert(newChatSessions);
            sessionId = newChatSessions.getId();
        }
        // 保存消息
        ChatMessages newChatMessages = new ChatMessages();

        newChatMessages.setUserId(sendMessageBO.getSenderId());
        newChatMessages.setSenderId(String.valueOf(sendMessageBO.getSenderId()));
        newChatMessages.setSessionId(sessionId);

        newChatMessages.setContent(sendMessageBO.getContent());

        newChatMessages.setSenderType(SenderTypeEnum.USER.getValue());
        newChatMessages.setMessageType(MessageTypeEnum.TEXT.getValue());

        newChatMessages.setCreatedAt(now);
        messagesMapper.insert(newChatMessages);
        // 发起对话请求
        ChatResponse chatResponse = zhiPuAiChatModel.call(PromptManage.ordinaryPrompt(sendMessageBO.getContent()));

        // 保存模型回复
        ChatMessages replyMessages = new ChatMessages();

        replyMessages.setSenderId(chatResponse.getMetadata().getId());
        replyMessages.setSessionId(sessionId);

        replyMessages.setSenderType(SenderTypeEnum.BOT.getValue());
        replyMessages.setMessageType(MessageTypeEnum.TEXT.getValue());

        String content = chatResponse.getResult().getOutput().getContent();
        replyMessages.setContent(content);

        replyMessages.setCreatedAt(LocalDateTime.now());
        replyMessages.setUserId(sendMessageBO.getSenderId());
        messagesMapper.insert(replyMessages);

        ReplyMessageBO model = new ReplyMessageBO();

        model.setContent(content);
        model.setSessionId(sessionId);
        model.setSenderType(SenderTypeEnum.BOT.getValue());
        return model;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ChatSessionBO> userSessions(Long userId) {
        List<ChatSessions> sessions = sessionsMapper.selectByUserId(userId);
        if (CollectionUtil.isEmpty(sessions)) {
            return Collections.emptyList();
        }
        return BeanUtil.copyToList(sessions, ChatSessionBO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReplyMessageBO> messageHistory(Long userId, String sessionId) {
        List<ChatMessages> chatMessages = messagesMapper.selectByUserIdAndSessionId(userId, sessionId);
        if (CollectionUtils.isEmpty(chatMessages)) {
            return Collections.emptyList();
        }
        return BeanUtil.copyToList(chatMessages,ReplyMessageBO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void clearHistory(Long userId, Long sessionId) {
        boolean existed = messagesMapper.existedByUserIdAndSessionId(userId,sessionId);
        if (existed) {
            messagesMapper.deleteByUserIdAndSessionId(userId,sessionId);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSession(String sessionId) {
        // 判断会话是否存在
        ChatSessions chatSessions = sessionsMapper.selectById(sessionId);
        if (Objects.isNull(chatSessions)) {
            return;
        }
        sessionsMapper.deleteById(sessionId);
        boolean existed = messagesMapper.existedBySessionId(sessionId);
        if (existed) {
            messagesMapper.deleteBySessionId(sessionId);
        }

    }
}
