package com.icb.sso.emuns;

import com.icb.common.enums.BaseEnum;

/**
 * @Description: 用户状态枚举
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午5:25 2023/6/30
 */
public enum UserStatusEnum implements BaseEnum<Integer> {
    UNACTIVATED( 0,"禁用"),

    ACTIVATE( 1,"启用"),
    ;

    private final Integer value;

    private final String name;

    UserStatusEnum(Integer value, String name) {
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
