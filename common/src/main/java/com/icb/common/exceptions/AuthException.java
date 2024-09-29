package com.icb.common.exceptions;


import com.icb.common.error.ErrorCode;
import com.icb.common.error.SystemErrorCode;

/**
 * 权限异常
 */
public class AuthException extends AbstractException {

    protected AuthException(ErrorCode code) {
        super(code);
    }

    protected AuthException(ErrorCode code, String message) {
        super(code, message);
    }

    protected AuthException(ErrorCode code, String message, Throwable ex) {
        super(code, message, ex);
    }

    public static AuthException of(String message) {
        return of(SystemErrorCode.UNAUTHORIZED, message);
    }

    public static AuthException of(int code, String message) {
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

    public static AuthException of(ErrorCode errorCode) {
        return new AuthException(errorCode);
    }

    public static AuthException of(ErrorCode errorCode, String message) {
        return new AuthException(errorCode, message);
    }

    public static AuthException of(ErrorCode errorCode, String message, Throwable exception) {
        if (exception instanceof AuthException && errorCode != null) {
            AuthException source = (AuthException) exception;
            if (errorCode.getCode() != source.getCode()) {
                return new AuthException(errorCode, message, source);
            }
            return source;
        }
        return new AuthException(errorCode, message, exception);
    }
}
