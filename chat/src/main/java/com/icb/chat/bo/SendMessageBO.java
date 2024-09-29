package com.icb.chat.bo;

import lombok.Data;

/**
 * 消息发送
 */
@Data
public class SendMessageBO {

    /**
     * 会话ID
     */
    private String sessionId;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 发送者ID
     */
    private Long senderId;
}
