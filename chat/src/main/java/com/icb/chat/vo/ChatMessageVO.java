package com.icb.chat.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ChatMessageVO implements Serializable {

    /**
     * 消息ID
     */
    private String id;

    /**
     * 会话ID
     */
    private String sessionId;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 消息发送时间
     */
    private LocalDateTime createdAt;

    /**
     * 消息发送类型 1-user 2-bot
     */
    private Integer senderType;
}
