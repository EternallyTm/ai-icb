package com.icb.sso.errors;

import com.icb.common.error.ErrorCode;

/**
 * @Description:
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午4:20 2023/7/1
 */
public enum SsoErrorCode implements ErrorCode {
    INVALID_PASSWORD_OR_LOGIN_NAME(1000,"用户名或密码错误"),
    USER_NOT_EXISTED(1001,"用户不存在"),
    USER_NOT_ACTIVATED(1002,"当前账号处于未激活或禁用状态"),
    ;

    private int code;

    private String message;


    SsoErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
