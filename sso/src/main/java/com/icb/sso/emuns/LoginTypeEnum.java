package com.icb.sso.emuns;

import com.icb.common.enums.BaseEnum;
import com.icb.common.exceptions.BizException;
import lombok.Getter;

/**
 * @Description:
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午2:14 2023/7/1
 */
public enum LoginTypeEnum implements BaseEnum<Integer> {
    LOGIN_NAME_AND_PASSWORD(0,"登录名+密码登录","loginNamePasswordLoginStrategy"),
    // 暂不实现，保留设计
    MOBILE_AND_CODE(1,"手机号+验证码登录","mobileSmsCodeLoginStrategy")
    ;

    private final Integer value;

    private final String name;

    @Getter
    private String strategy;

    LoginTypeEnum(int value, String name, String strategy) {
        this.value = value;
        this.name = name;
        this.strategy = strategy;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public static LoginTypeEnum of(Integer value) {
        LoginTypeEnum[] values = LoginTypeEnum.values();
        for (LoginTypeEnum loginTypeEnum : values) {
            if (loginTypeEnum.value == value) {
                return loginTypeEnum;
            }
         }
        throw BizException.of("Invalid LoginTypeEnum value: " + value);
    }
}
