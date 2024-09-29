package com.icb.mdm.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 菜单表
 */
@Data
public class MenuBO {
    private Long id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父菜单ID，一级菜单为0
     */
    private Long pid;

    /**
     * 使用场景：1-管理端 2-用户端
     */
    private Integer useScenes;

    /**
     * 菜单路由路径
     */
    private String path;

    private String redirect;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String perms;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Integer type;

    /**
     * 是否显示 0-不显示，1-显示
     */
    private Integer status;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 是否隐藏：0-显示，1-隐藏
     */
    private Boolean hidden;

    /**
     * 数据的层级结构：按上级id加,号分割
     */
    private String code;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Long createUserId;

    /**
     * 更行时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private Long updateUserId;
}