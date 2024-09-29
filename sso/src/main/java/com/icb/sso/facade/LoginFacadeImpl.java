package com.icb.sso.facade;

import cn.hutool.core.bean.BeanUtil;
import com.icb.sso.api.LoginFacade;
import com.icb.sso.api.entity.CheckPermissionDTO;
import com.icb.sso.api.entity.SsoUserDTO;
import com.icb.sso.bo.CheckUserAuthCodeBO;
import com.icb.sso.bo.SsoUserBO;
import com.icb.sso.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class LoginFacadeImpl implements LoginFacade {

    @Autowired
    private LoginService loginService;

    @Override
    public SsoUserDTO getUserByToken(String token) {
        SsoUserBO ssoUserBO = loginService.findSsoUserByToken(token);
        if (Objects.isNull(ssoUserBO)) {
            return null;
        }
        return BeanUtil.toBean(ssoUserBO,SsoUserDTO.class);
    }

    @Override
    public Boolean checkPermission(CheckPermissionDTO checkPermissionDTO) {
        CheckUserAuthCodeBO checkUserAuthCodeBO = BeanUtil.toBean(checkPermissionDTO, CheckUserAuthCodeBO.class);
        return loginService.checkUserAuthByCodes(checkUserAuthCodeBO);
    }
}
