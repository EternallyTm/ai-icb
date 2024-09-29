package com.icb.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "icb_chat_messages")
public class ChatMessages {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 会话用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 会话ID
     */
    @TableField(value = "session_id")
    private String sessionId;

    /**
     * 发送者ID，根据sender_type区分botId还是用户的userId
     */
    @TableField(value = "sender_id")
    private String senderId;

    /**
     * 消息发送类型：1-user,2-bot
     */
    @TableField(value = "sender_type")
    private Integer senderType;

    /**
     * 消息内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 1-text 2-image 3-file
     */
    @TableField(value = "message_type")
    private Integer messageType;

    @TableField(value = "created_at")
    private LocalDateTime createdAt;
}