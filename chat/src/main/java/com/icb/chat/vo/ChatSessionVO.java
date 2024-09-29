package com.icb.chat.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ChatSessionVO implements Serializable {

    private String id;

    private String title;

    private LocalDateTime createdAt;
}
