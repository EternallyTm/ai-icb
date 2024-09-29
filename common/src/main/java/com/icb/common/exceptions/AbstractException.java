package com.icb.common.exceptions;

import com.icb.common.error.ErrorCode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常基类
 */
public abstract class AbstractException extends RuntimeException {

    private final int code;
    private Map<String, Object> attributes;

    protected AbstractException(ErrorCode code) {
        super(code.getMessage());
        this.code = code.getCode();
    }

    protected AbstractException(ErrorCode code, String message) {
        super(message);
        this.code = code.getCode();
    }

    protected AbstractException(ErrorCode code, String message, Throwable ex) {
        super(message, ex);
        this.code = code.getCode();
    }

    /**
     * 为异常添加属性
     *
     * @param key   属性键
     * @param value 属性值
     * @return 当前异常对象
     */
    public AbstractException putAttribute(String key, Object value) {
        if (attributes == null) {
            attributes = new HashMap<>();
        }
        attributes.put(key, value);
        return this;
    }

    /**
     * 获取异常属性
     *
     * @return 异常属性
     */
    public Map<String, Object> getAttributes() {
        return attributes == null ? Collections.emptyMap() : Collections.unmodifiableMap(attributes);
    }

    /**
     * 设置异常属性
     *
     * @param attributes 异常属性
     * @return 当前异常对象
     */
    public AbstractException setAttributes(Map<String, Object> attributes) {
        if (attributes != null) {
            this.attributes = new HashMap<>(attributes);
        }
        return this;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "AbstractException{" +
                "code=" + code +
                ", attributes=" + attributes +
                "} " + super.toString();
    }
}
