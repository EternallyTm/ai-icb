package com.icb.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 */
@Data
@TableName(value = "icb_user")
public class User {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 用户姓名
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 登录名：默认使用邮箱作为登录名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 手机号
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 0-未启用 1-已启用
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 账号类型：1-运营账号 2-外部账号
     */
    @TableField(value = "`type`")
    private Integer type;

    /**
     * 企业code,外部企业账号时不为空
     */
    @TableField(value = "company_id")
    private Long companyId;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    private String password;

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