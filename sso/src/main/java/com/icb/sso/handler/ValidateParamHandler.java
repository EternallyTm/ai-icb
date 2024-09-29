package com.icb.sso.handler;

import com.icb.common.utils.AssertUtil;
import com.icb.sso.emuns.LoginTypeEnum;
import com.icb.sso.bo.SsoLoginResBO;
import com.icb.sso.bo.LoginBO;
import org.springframework.stereotype.Component;


/**
 * @Description:
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午3:52 2023/7/1
 */
@Component("validateParamHandler")
public class ValidateParamHandler extends AbstractLoginHandler {
    @Override
    public SsoLoginResBO doHandler(LoginBO model) {
        LoginTypeEnum loginType = model.getType();
        // 参数验证
        if (loginType == LoginTypeEnum.LOGIN_NAME_AND_PASSWORD) {
            AssertUtil.notBlank(model.getUsername(), "登录名不能为空");
            AssertUtil.notBlank(model.getPassword(), "登录密码不能为空");
        } else if (loginType == LoginTypeEnum.MOBILE_AND_CODE) {
            AssertUtil.notBlank(model.getUsername(), "手机号不能为空");
            AssertUtil.notBlank(model.getEmailCode(), "验证码不能为空");
        }
        if (hasNext()) {
            return next.doHandler(model);
        }
        return null;
    }
}
