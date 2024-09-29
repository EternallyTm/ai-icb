package com.icb.common.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 100000以下不含100000为内部异常
 *
 * @author wangxing
 */
@Getter
@RequiredArgsConstructor
public enum SystemErrorCode implements ErrorCode {

    /**
     * 请求成功
     */
    SUCCESS(200, "请求成功"),

    /**
     * 错误请求
     */
    BAD_REQUEST(400, "错误请求"),
    /**
     * 未授权访问
     */
    UNAUTHORIZED(401, "未授权访问"),

    /**
     * 访问禁止
     */
    FORBIDDEN(403, "访问禁止"),
    /**
     * 访问禁止
     */
    NOT_FOUND(404, "资源未找到"),

    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),

    /**
     * 通用业务异常
     */
    BUSINESS_EXCEPTION(100000, "业务异常"),

    /**
     * 常用业务异常：数据不存在
     */
    DATA_NOT_EXISTS(100001, "数据不存在"),
    /**
     * 非法参数
     */
    INVALID_PARAMETER(100003, "参数非法");

    /**
     * 错误码
     */
    private final int code;
    /**
     * 错误消息
     */
    private final String message;

}