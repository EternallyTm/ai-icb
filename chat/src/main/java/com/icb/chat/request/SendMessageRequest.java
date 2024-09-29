package com.icb.chat.request;

import lombok.Data;

@Data
public class SendMessageRequest {

    /**
     * 会话ID
     */
    private Long sessionId;

    /**
     * 消息内容
     */
//    @NotBlank(message = "消息内容不能为空")
    private String content;
}
