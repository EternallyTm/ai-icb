package com.icb.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 角色表
 */
@Data
@TableName(value = "icb_role")
public class Role {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 角色名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 角色状态：0-禁用 1-启用
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 企业id: 企业下自定义角色时存在
     */
    @TableField(value = "company_id")
    private Long companyId;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

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