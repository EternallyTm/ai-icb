package com.icb.sso.strategy;

import com.icb.common.exceptions.AuthException;
import com.icb.sso.bo.SsoUserBO;
import com.icb.sso.bo.LoginBO;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午4:11 2023/7/1
 */
@Component("mobileSmsCodeLoginStrategy")
public class MobileSmsCodeAccountValidateStrategy implements AccountValidateStrategy {

    @Override
    public SsoUserBO validate(LoginBO model) {
        throw AuthException.of("手机号验证码登录建设中");
    }
}
