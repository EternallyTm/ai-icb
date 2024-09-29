package com.icb.common.model;



import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseBO {

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private Long createUserId;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    private Long updateUserId;
}
