package com.icb.common.error;

/**
 * @Description:
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 上午10:28 2023/7/2
 */
public enum JWTErrorCode implements ErrorCode {
    TOKEN_GENERATION_EXCEPTION(2001,"token生成异常"),
    TOKEN_EXPIRED(2002,"token已过期"),
    TOKEN_SIGNATURE_INVALID(2003,"Token签名无效")
    ;

    private int code;

    private String message;

    JWTErrorCode(int code, String message) {
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
