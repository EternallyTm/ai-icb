package com.icb.bootstrap;

import com.icb.common.error.ErrorCode;
import com.icb.common.error.SystemErrorCode;
import com.icb.common.exceptions.AbstractException;
import com.icb.common.exceptions.AuthException;
import com.icb.common.exceptions.BizException;
import com.icb.common.model.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Locale;
import java.util.Map;
import java.util.HashMap;

@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private MessageSource messageSource;

    @Value("${global.showErrorStack:false}")
    private boolean showErrorStack;

    @ExceptionHandler(AuthException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiResult<?> handleAuthException(AuthException ex) {
        return ApiResult.error(buildErrorCode(ex));
    }

    @ExceptionHandler(BizException.class)
    public ApiResult<?> handleBizException(BizException ex) {
        logBizException(ex);
        return ApiResult.error(buildErrorCode(ex), ex.getAttributes());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResult<?> handleException(Exception ex) {
        log.error("An unexpected error occurred", ex);
        return showErrorStack
                ? buildErrorResponseWithStackTrace(ex)
                : ApiResult.error(SystemErrorCode.INTERNAL_SERVER_ERROR.getCode(), ex.getMessage());
    }

    private ErrorCode buildErrorCode(AbstractException ex) {
        Locale locale = LocaleContextHolder.getLocale();
        String errorMessage = messageSource.getMessage(String.valueOf(ex.getCode()), null, ex.getMessage(), locale);
        return new ErrorCode() {
            @Override
            public int getCode() {
                return ex.getCode();
            }

            @Override
            public String getMessage() {
                return errorMessage;
            }
        };
    }

    private void logBizException(BizException ex) {
        if (showErrorStack) {
            log.warn("BIZ_ERROR[{}]:{}", ex.getCode(), ex.getMessage(), ex);
        } else {
            String logMessage = ex.getAttributes() != null && !ex.getAttributes().isEmpty()
                    ? "BIZ_ERROR[{}]:{}\tattributes:{}"
                    : "BIZ_ERROR[{}]:{}";
            log.warn(logMessage, ex.getCode(), ex.getMessage(), ex.getAttributes());
        }
    }

    private ApiResult<Map<String, Object>> buildErrorResponseWithStackTrace(Exception ex) {
        Map<String, Object> params = new HashMap<>();
        StringBuilder stackTraceBuilder = new StringBuilder();

        for (StackTraceElement element : ex.getStackTrace()) {
            stackTraceBuilder.append(element.toString()).append("\r\n");
        }

        params.put("Error Info", stackTraceBuilder.toString());
        return ApiResult.error(SystemErrorCode.INTERNAL_SERVER_ERROR, params);
    }
}
