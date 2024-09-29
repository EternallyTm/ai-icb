package com.icb.common.exceptions;

import com.icb.common.error.ErrorCode;
import com.icb.common.error.SystemErrorCode;

/**
 * 业务异常
 */
public class BizException extends AbstractException {

    private BizException(ErrorCode code) {
        super(code);
    }

    private BizException(ErrorCode code, String message) {
        super(code, message);
    }

    private BizException(ErrorCode code, String message, Throwable ex) {
        super(code, message, ex);
    }

    public static BizException of(String message) {
        return of(SystemErrorCode.BUSINESS_EXCEPTION, message);
    }

    public static BizException dataNotExists() {
        return of(SystemErrorCode.DATA_NOT_EXISTS);
    }

    public static BizException of(int code, String message) {
        return of(new ErrorCode() {
            @Override
            public int getCode() {
                return code;
            }

            @Override
            public String getMessage() {
                return message;
            }
        });
    }

    public static BizException of(ErrorCode errorCode) {
        return new BizException(errorCode);
    }

    public static BizException of(ErrorCode errorCode, String message) {
        return new BizException(errorCode, message);
    }

    public static BizException of(ErrorCode errorCode, String message, Throwable exception) {
        if (exception instanceof BizException && errorCode != null) {
            BizException source = (BizException) exception;
            if (errorCode.getCode() != source.getCode()) {
                return new BizException(errorCode, message, source);
            }
            return source;
        }
        return new BizException(errorCode, message, exception);
    }
}
