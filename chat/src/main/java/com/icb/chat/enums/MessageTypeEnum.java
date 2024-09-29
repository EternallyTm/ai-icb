package com.icb.chat.enums;

import com.icb.common.enums.BaseEnum;
import com.icb.common.exceptions.BizException;

public enum MessageTypeEnum implements BaseEnum<Integer> {

    TEXT(1,"TEXT"),
    IMAGE(2,"IMAGE"),
    FILE(3,"FILE")

    ;

    MessageTypeEnum(Integer value, String name) {
        this.name = name;
        this.value = value;
    }

    private Integer value;

    private String name;

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public static MessageTypeEnum of(Integer value) {
        MessageTypeEnum[] values = MessageTypeEnum.values();
        for (MessageTypeEnum senderTypeEnum : values) {
            if (senderTypeEnum.value.equals(value)) {
                return senderTypeEnum;
            }
        }
        throw BizException.of("unsupported SenderTypeEnum value [" + value + "]");
    }
}
