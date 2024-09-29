package com.icb.sso.handler;


import com.icb.sso.bo.SsoLoginResBO;
import com.icb.sso.bo.SsoUserBO;
import com.icb.sso.bo.LoginBO;
import com.icb.sso.strategy.AccountValidateStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Map;

/**
 * @Description: 账号正确性校验
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午4:09 2023/7/1
 */
@Component("validateAccountHandler")
public class ValidateAccountHandler extends AbstractLoginHandler {

    @Autowired
    private Map<String, AccountValidateStrategy> loginStrategyMap;

    @Override
    public SsoLoginResBO doHandler(LoginBO model) {
        // 根据登录方式校验用户正确性
        AccountValidateStrategy accountValidateStrategy = loginStrategyMap.get(model.getType().getStrategy());
        SsoUserBO ssoUserBO = accountValidateStrategy.validate(model);
        model.setSsoUserBO(ssoUserBO);
        if (hasNext()) {
            return next.doHandler(model);
        }
        return null;
    }
}
