package com.icb.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 企业表
 */
@Data
@TableName(value = "icb_company")
public class Company {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 企业名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 统一社会信用代码
     */
    @TableField(value = "unified_social_code")
    private String unifiedSocialCode;

    /**
     * 企业状态：0-待审核 1-审核通过 2-审核拒绝
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 管理员账号ID
     */
    @TableField(value = "admin_user_id")
    private Long adminUserId;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private Date createdAt;

    /**
     * 创建人
     */
    @TableField(value = "created_by")
    private Long createdBy;

    /**
     * 更新时间
     */
    @TableField(value = "updated_at")
    private Date updatedAt;

    @TableField(value = "updated_by")
    private Long updatedBy;
}