package com.icb.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 菜单表
 */
@Data
@TableName(value = "icb_menu")
public class Menu {
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 菜单名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 父菜单ID，一级菜单为0
     */
    @TableField(value = "pid")
    private Long pid;

    /**
     * 使用场景：1-管理端 2-用户端
     */
    @TableField(value = "use_scenes")
    private Integer useScenes;

    /**
     * 菜单路由路径
     */
    @TableField(value = "`path`")
    private String path;

    @TableField(value = "redirect")
    private String redirect;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    @TableField(value = "perms")
    private String perms;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    @TableField(value = "`type`")
    private Integer type;

    /**
     * 是否显示 0-不显示，1-显示
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 菜单图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 是否隐藏：0-显示，1-隐藏
     */
    @TableField(value = "hidden")
    private Boolean hidden;

    /**
     * 数据的层级结构：按上级id加,号分割
     */
    @TableField(value = "code")
    private String code;

    /**
     * 排序
     */
    @TableField(value = "order_num")
    private Integer orderNum;

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
     * 更行时间
     */
    @TableField(value = "updated_at")
    private Date updatedAt;

    /**
     * 更新人
     */
    @TableField(value = "updated_by")
    private Long updatedBy;
}