package com.icb.chat.bo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ChatSessionBO implements Serializable {
    
    private String id;

    private String title;

    private Long userId;

    private LocalDateTime createdAt;
}
