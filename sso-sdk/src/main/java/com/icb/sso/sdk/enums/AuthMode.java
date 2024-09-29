package com.icb.sso.sdk.enums;

/**
 * @Description: 鉴权方式
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 上午11:08 2023/7/2
 */
public enum AuthMode {


    // 只需要登录
    ONLY_LOGIN,

    // 权限码鉴权
    PERMISSION;

    /**
     * 是否需要鉴权
     * @author: wangxing <1028106567@qq.com>
     * @return
     */
    public boolean isNeedAuth() {
        return this == PERMISSION;
    }

}
