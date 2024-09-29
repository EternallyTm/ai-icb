package com.icb.mdm.enums;

import com.icb.common.enums.BaseEnum;

/**
 * @Description: 资源类型枚举
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午5:25 2023/6/30
 */
public enum MenuScenesEnum implements BaseEnum<Integer> {

    // 权限类型: 1=目录，C=菜单，A=按钮
    CLIENT( 1,"客户端"),

    ADMIN(2,"管理端"),

    ;

    private Integer value;

    private String name;

    MenuScenesEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
