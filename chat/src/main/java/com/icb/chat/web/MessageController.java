package com.icb.chat.web;

import cn.hutool.core.bean.BeanUtil;
import com.icb.chat.bo.ChatSessionBO;
import com.icb.chat.bo.SendMessageBO;
import com.icb.chat.bo.ReplyMessageBO;
import com.icb.chat.request.SendMessageRequest;
import com.icb.chat.service.MessageService;
import com.icb.chat.vo.ChatSessionVO;
import com.icb.chat.vo.ChatMessageVO;
import com.icb.common.model.ApiResult;
import com.icb.sso.sdk.annotations.Authentication;
import com.icb.sso.sdk.controller.BaseController;
import com.icb.sso.sdk.enums.AuthMode;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/chat/message/v1/")
@Authentication(mode = AuthMode.ONLY_LOGIN)
public class MessageController extends BaseController {

    @Autowired
    private MessageService messageService;

    /**
     * 发送聊天消息
     * @param request
     * @return
     */
    @PostMapping("/send-message")
    public ApiResult<ChatMessageVO> sendMessage(@RequestBody SendMessageRequest request) {
        SendMessageBO sendMessageBO = BeanUtil.toBean(request, SendMessageBO.class);
        sendMessageBO.setSenderId(loginUserId());
        ReplyMessageBO replyMessageBO = messageService.sendMessage(sendMessageBO);
        ChatMessageVO chatMessageVO = BeanUtil.toBean(replyMessageBO, ChatMessageVO.class);
        return ApiResult.success(chatMessageVO);
    }

    @GetMapping("/user-sessions")
    public ApiResult<List<ChatSessionVO>> userSessions() {
        List<ChatSessionBO> chatSessions = messageService.userSessions(loginUserId());
        if (CollectionUtils.isEmpty(chatSessions)) {
            return ApiResult.success(Collections.emptyList());
        }
        return ApiResult.success(BeanUtil.copyToList(chatSessions, ChatSessionVO.class));
    }

    @GetMapping("/message-history")
    public ApiResult<List<ChatMessageVO>> messageHistory(@RequestParam("sessionId") String sessionId) {
        List<ReplyMessageBO> replyMessageBOS = messageService.messageHistory(loginUserId(),sessionId);
        if (CollectionUtils.isEmpty(replyMessageBOS)) {
            return ApiResult.success(Collections.emptyList());
        }
        return ApiResult.success(BeanUtil.copyToList(replyMessageBOS, ChatMessageVO.class));
    }

    /**
     * @deprecated 清除聊天记录的同时删除会话信息 {@link MessageController#deleteSession(String) }
     * @param sessionId
     * @return
     */
    @PostMapping("/clear-history")
    @Deprecated
    public ApiResult<Void> clearHistory(@RequestParam("sessionId") Long sessionId) {
        messageService.clearHistory(loginUserId(),sessionId);
        return ApiResult.success();
    }

    @PostMapping("/delete-session")
    public ApiResult<Void> deleteSession(@RequestParam("sessionId") String sessionId) {
        messageService.deleteSession(sessionId);
        return ApiResult.success();
    }
}
