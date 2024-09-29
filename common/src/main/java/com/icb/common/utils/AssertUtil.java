package com.icb.common.utils;



import com.icb.common.error.ErrorCode;
import com.icb.common.exceptions.BizException;

import java.util.Collection;
import java.util.Map;

public class AssertUtil {

    public static void isTrue(boolean expression, ErrorCode errorCode) {
        if (!expression) {
            throw BizException.of(errorCode);
        }
    }

    public static void isFalse(boolean expression, ErrorCode errorCode) {
        isTrue(!expression, errorCode);
    }

    public static void notNull(Object object, ErrorCode errorCode) {
        isTrue(object != null, errorCode);
    }

    public static void isNull(Object object, ErrorCode errorCode) {
        isTrue(object == null, errorCode);
    }

    public static void notEmpty(Collection<?> collection, ErrorCode errorCode) {
        isTrue(collection != null && !collection.isEmpty(), errorCode);
    }

    public static void notEmpty(Map<?, ?> map, ErrorCode errorCode) {
        isTrue(map != null && !map.isEmpty(), errorCode);
    }

    public static void notBlank(String string, ErrorCode errorCode) {
        isTrue(string != null && !string.trim().isEmpty(), errorCode);
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw BizException.of(message);
        }
    }

    public static void isFalse(boolean expression, String message) {
        isTrue(!expression, message);
    }

    public static void notNull(Object object, String message) {
        isTrue(object != null, message);
    }

    public static void isNull(Object object, String message) {
        isTrue(object == null, message);
    }

    public static void notEmpty(Collection<?> collection, String message) {
        isTrue(collection != null && !collection.isEmpty(), message);
    }

    public static void notEmpty(Map<?, ?> map, String message) {
        isTrue(map != null && !map.isEmpty(), message);
    }

    public static void notBlank(String string, String message) {
        isTrue(string != null && !string.trim().isEmpty(), message);
    }
}
