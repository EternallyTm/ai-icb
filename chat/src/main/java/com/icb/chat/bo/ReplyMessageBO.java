package com.icb.chat.bo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ReplyMessageBO implements Serializable {

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
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 发送者类型
     */
    private Integer senderType;
}
