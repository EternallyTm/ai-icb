package com.icb.sso.sdk.enums;

import com.icb.common.enums.BaseEnum;
import com.icb.common.exceptions.BizException;

/**
 * @Description: Enum representing different user types.
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午5:25 2023/6/30
 */
public enum UserTypeEnum implements BaseEnum<Integer> {

    OPERATOR(1, "运营人员"),
    EXTERNAL(2, "外部账号"),
    EXTERNAL_ADMIN(3, "外部账号-管理员");

    private final Integer value;
    private final String name;

    UserTypeEnum(Integer value, String name) {
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

    public static UserTypeEnum of(Integer type) {
        for (UserTypeEnum userTypeEnum : values()) {
            if (userTypeEnum.value.equals(type)) {
                return userTypeEnum;
            }
        }
        throw BizException.of("Invalid UserTypeEnum value: " + type);
    }

    public boolean isOperator() {
        return this == OPERATOR;
    }

    public boolean isExternal() {
        return this == EXTERNAL || this == EXTERNAL_ADMIN;
    }

    public boolean isExternalAdmin() {
        return this == EXTERNAL_ADMIN;
    }

    public boolean isNormal() {
        return this == EXTERNAL;
    }
}
