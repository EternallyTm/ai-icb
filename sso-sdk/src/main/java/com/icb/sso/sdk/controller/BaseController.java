package com.icb.sso.sdk.controller;


import com.icb.sso.api.entity.SsoUserDTO;
import com.icb.sso.sdk.context.AuthContextHolder;
import com.icb.sso.sdk.enums.UserTypeEnum;

/**
 * @Description:
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午3:33 2023/7/2
 */
public class BaseController {

    protected SsoUserDTO loginAuthUser() {
        return AuthContextHolder.getSsoUser();
    }

    protected Long loginUserId() {
        return loginAuthUser().getId();
    }

    protected Long loginCompanyId() {
        return loginAuthUser().getCompanyId();
    }

    private UserTypeEnum loginUserType() {
        return UserTypeEnum.of(loginAuthUser().getType());
    }

    protected boolean isOperator() {
        return loginUserType().isOperator();
    }

    protected boolean isExternalAdmin() {
        return loginUserType().isExternalAdmin();
    }

    protected boolean isNormal() {
        return loginUserType().isNormal();
    }
}
