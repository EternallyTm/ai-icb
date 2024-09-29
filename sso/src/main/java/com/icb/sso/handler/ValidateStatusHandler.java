package com.icb.sso.handler;

import com.icb.common.exceptions.AuthException;
import com.icb.sso.emuns.UserStatusEnum;
import com.icb.sso.errors.SsoErrorCode;
import com.icb.sso.bo.SsoLoginResBO;
import com.icb.sso.bo.SsoUserBO;
import com.icb.sso.bo.LoginBO;
import org.springframework.stereotype.Component;

/**
 * @author wangxing
 * 检验用户状态是否正常
 */
@Component("validateStatusHandler")
public class ValidateStatusHandler extends AbstractLoginHandler {


    @Override
    public SsoLoginResBO doHandler(LoginBO model) {
        SsoUserBO ssoUserBO = model.getSsoUserBO();
        // 校验用户状态
        if (UserStatusEnum.UNACTIVATED.getValue().equals(ssoUserBO.getStatus())) {
            throw AuthException.of(SsoErrorCode.USER_NOT_ACTIVATED);
        }
        if (hasNext()) {
            return next.doHandler(model);
        }
        return null;
    }

}
