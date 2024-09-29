package com.icb.sso.strategy;


import com.icb.sso.bo.SsoUserBO;
import com.icb.sso.bo.LoginBO;
import reactor.core.publisher.Mono;

/**
 * @Description: 登录策略
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午4:11 2023/7/1
 */
public interface AccountValidateStrategy {

    SsoUserBO validate(LoginBO model);
}
