package com.icb.common.model;

import com.icb.common.error.SystemErrorCode;
import com.icb.common.error.ErrorCode;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一响应模型
 *
 * @author wnagxing
 */
@Data
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 2081104351106889132L;

    /**
     * 是否成功，true：成功，false：失败
     */
    private boolean success;
    /**
     * 错误码
     * 非异常为200
     */
    private int code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;

    private ApiResult() {
        this.success = true;
        this.code = SystemErrorCode.SUCCESS.getCode();
        this.message = SystemErrorCode.SUCCESS.getMessage();
    }

    private ApiResult(T data) {
        this.success = true;
        this.code = SystemErrorCode.SUCCESS.getCode();
        this.message = SystemErrorCode.SUCCESS.getMessage();
        this.data = data;
    }

    private ApiResult(int code, String message) {
        this.success = false;
        this.code = code;
        this.message = message;
    }

    private ApiResult(int code, String message, T data) {
        this.success = false;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResult<T> success() {
        return new ApiResult<>();
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(data);
    }

    public static <T> ApiResult<T> error(int code, String message) {
        return new ApiResult<>(code, message);
    }

    public static <T> ApiResult<T> error(ErrorCode errorCode) {
        return new ApiResult<>(errorCode.getCode(), errorCode.getMessage());
    }

    public static <T> ApiResult<T> error(ErrorCode errorCode, T data) {
        return new ApiResult<>(errorCode.getCode(), errorCode.getMessage(), data);
    }

    public static <T> ApiResult<T> badRequest(String message) {
        return new ApiResult<>(SystemErrorCode.BAD_REQUEST.getCode(), message);
    }

    public static <T> ApiResult<T> badRequest(String message, T data) {
        return new ApiResult<>(SystemErrorCode.BAD_REQUEST.getCode(), message, data);
    }
}