package com.icb.mdm.vo.menu;

import com.icb.common.model.TreeNode;
import lombok.Data;

import java.util.Collection;

@Data
public class MenuVO implements TreeNode<Long, MenuVO> {

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


    private Collection<MenuVO> children;
}
