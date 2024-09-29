package com.icb.sso.handler;


import com.icb.sso.bo.SsoLoginResBO;
import com.icb.sso.bo.LoginBO;
import org.springframework.stereotype.Component;

/**
 * @Description: 风险校验，可以加入一些账号风险把控的能力
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午3:52 2023/7/1
 */
@Component("validateRiskHandler")
public class ValidateRiskHandler extends AbstractLoginHandler{
    @Override
    public SsoLoginResBO doHandler(LoginBO model) {
        if (hasNext()) {
            return next.doHandler(model);
        }
        return null;
    }
}
