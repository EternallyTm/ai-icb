package com.icb.sso.web;

import cn.hutool.core.bean.BeanUtil;
import com.icb.common.error.SystemErrorCode;
import com.icb.common.exceptions.AuthException;
import com.icb.common.model.ApiResult;
import com.icb.sso.bo.LoginBO;
import com.icb.sso.bo.SsoLoginResBO;
import com.icb.sso.bo.SsoUserBO;
import com.icb.sso.handler.AbstractLoginHandler;
import com.icb.sso.request.LoginRequest;
import com.icb.sso.service.LoginService;
import com.icb.sso.utils.TokenUtils;
import com.icb.sso.vo.SsoLoginVO;
import com.icb.sso.vo.SsoUserVO;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/sso/v1")
public class SsoController {

    @Autowired
    @Qualifier(value = "validateParamHandler")
    private AbstractLoginHandler abstractLoginHandler;

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login")
    public ApiResult<SsoLoginVO> login(@RequestBody LoginRequest request) {
        LoginBO loginBO = BeanUtil.toBean(request, LoginBO.class);
        SsoLoginResBO ssoLoginResBO = abstractLoginHandler.doHandler(loginBO);
        return ApiResult.success(ssoLoginResBO.toSsoUserVO());
    }

    @GetMapping(value = "/logout")
    public ApiResult<Void> logout(HttpServletRequest request) {
        String token = TokenUtils.extractToken(request);
        if (StringUtils.isNotBlank(token)) {
            loginService.logout(token);
        }
        return ApiResult.success();
    }

    @GetMapping("/current-info")
    private ApiResult<SsoUserVO> currentUser(HttpServletRequest request) {
        String token = TokenUtils.extractToken(request);
        if (StringUtils.isBlank(token)) {
            throw AuthException.of(SystemErrorCode.UNAUTHORIZED);
        }
        SsoUserBO ssoUserBO = loginService.findSsoUserByToken(token);
        if (Objects.isNull(ssoUserBO)) {
            throw AuthException.of(SystemErrorCode.UNAUTHORIZED);
        }
        SsoUserVO ssoUserVO = BeanUtil.toBean(ssoUserBO, SsoUserVO.class);
        // 获取权限key
        List<String> permissionCodes = loginService.getAuthModel(ssoUserVO.getId()).getPermissionCodes();
        ssoUserVO.setPermissionCodes(permissionCodes);
        return ApiResult.success(ssoUserVO);
    }
}
