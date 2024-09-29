package com.icb.chat.enums;

import com.icb.common.enums.BaseEnum;
import com.icb.common.exceptions.BizException;

public enum SenderTypeEnum implements BaseEnum<Integer> {

    USER(1,"USER"),
    BOT(2,"BOT")

    ;

    SenderTypeEnum(Integer value,String name) {
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

    public static SenderTypeEnum of(Integer value) {
        SenderTypeEnum[] values = SenderTypeEnum.values();
        for (SenderTypeEnum senderTypeEnum : values) {
            if (senderTypeEnum.value.equals(value)) {
                return senderTypeEnum;
            }
        }
        throw BizException.of("unsupported SenderTypeEnum value [" + value + "]");
    }
}
