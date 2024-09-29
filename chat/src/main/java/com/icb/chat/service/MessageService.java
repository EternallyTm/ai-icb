package com.icb.chat.service;

import com.icb.chat.bo.ChatSessionBO;
import com.icb.chat.bo.SendMessageBO;
import com.icb.chat.bo.ReplyMessageBO;

import java.util.List;

/**
 * 消息服务
 */
public interface MessageService {

    /**
     * @Deprecated 使用langchain 替代
     * 发送消息
     * @param sendMessageBO
     * @return
     */
    @Deprecated
    ReplyMessageBO sendMessage(SendMessageBO sendMessageBO);

    /**
     * 获取当前用户的会话列表
     * @param userId
     * @return
     */
    List<ChatSessionBO> userSessions(Long userId);

    /**
     * 当前会话的聊天历史记录
     * @param userId
     * @param sessionId
     * @return
     */
    List<ReplyMessageBO> messageHistory(Long userId, String sessionId);

    /**
     * 清空当前会话的聊天历史记录
     * @param userId
     * @param sessionId
     */
    void clearHistory(Long userId, Long sessionId);

    /**
     * 删除会话
     * @param sessionId
     */
    void deleteSession(String sessionId);
}
