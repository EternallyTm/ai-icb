package com.icb.common.enums;

/**
 * @Description:
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午5:26 2023/6/30
 */
public interface BaseEnum<T> {

    T getValue();

    String getName();
}
