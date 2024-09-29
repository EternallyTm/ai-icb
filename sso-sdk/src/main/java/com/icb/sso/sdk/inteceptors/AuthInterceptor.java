package com.icb.sso.sdk.inteceptors;

import com.icb.common.error.SystemErrorCode;
import com.icb.common.exceptions.AuthException;
import com.icb.common.exceptions.BizException;
import com.icb.sso.api.LoginFacade;
import com.icb.sso.api.entity.CheckPermissionDTO;
import com.icb.sso.api.entity.SsoUserDTO;
import com.icb.sso.sdk.annotations.Authentication;
import com.icb.sso.sdk.context.AuthContextHolder;
import com.icb.sso.sdk.enums.AuthMode;
import com.icb.sso.sdk.enums.UserTypeEnum;
import com.icb.sso.sdk.utils.TokenUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Description: Handles authentication and authorization checks for incoming requests.
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午12:34 2023/7/1
 */
@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginFacade loginFacade;

    @Value("${sso.auth.auth-check:false}")
    private boolean isAuthCheck;

    private static final String ADMIN_API_PREFIX = "/api/admin";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        Authentication annotation = findAuthAnnotation((HandlerMethod) handler);
        if (annotation == null) {
            return true;
        }

        SsoUserDTO ssoUserDTO = verifyUserAndInjectContext(request, response);
        checkAuthorization(annotation, ssoUserDTO, request, response);

        return true;
    }

    private void checkAuthorization(Authentication annotation, SsoUserDTO ssoUserDTO, HttpServletRequest request, HttpServletResponse response) {
        if (!isAuthCheck) {
            log.info("Authorization check is disabled.");
            return;
        }

        if (annotation.mode() == AuthMode.ONLY_LOGIN) {
            return;
        }

        boolean hasAuthorization = verifyPermission(annotation, ssoUserDTO, request);
        if (!hasAuthorization) {
            log.warn("Unauthorized access attempt to URI: {}", request.getRequestURI());
            response.setStatus(HttpStatus.FORBIDDEN.value());
            throw AuthException.of(SystemErrorCode.FORBIDDEN);
        }
    }

    private boolean verifyPermission(Authentication annotation, SsoUserDTO ssoUserDTO, HttpServletRequest request) {
        if (!annotation.mode().isNeedAuth()) {
            return true;
        }

        validateInternalAccess(ssoUserDTO, request);

        String[] authCodes = annotation.authCode();
        if (authCodes.length == 0) {
            throw BizException.of("Authorization code(s) must be specified.");
        }

        CheckPermissionDTO permissionDTO = new CheckPermissionDTO(ssoUserDTO.getId(), Arrays.asList(authCodes));
        return loginFacade.checkPermission(permissionDTO);
    }

    private void validateInternalAccess(SsoUserDTO ssoUserDTO, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        if (requestURI.startsWith(ADMIN_API_PREFIX) && UserTypeEnum.of(ssoUserDTO.getType()).isExternal()) {
            log.error("External account attempting to access admin API. User ID: {}", ssoUserDTO.getId());
            throw AuthException.of(SystemErrorCode.FORBIDDEN);
        }
    }

    private SsoUserDTO verifyUserAndInjectContext(HttpServletRequest request, HttpServletResponse response) {
        String token = TokenUtils.extractToken(request);
        if (StringUtils.isBlank(token)) {
            return handleUnauthorized(response);
        }

        SsoUserDTO ssoUserDTO = loginFacade.getUserByToken(token);
        if (Objects.isNull(ssoUserDTO)) {
            return handleUnauthorized(response);
        }

        AuthContextHolder.bind(ssoUserDTO);
        return ssoUserDTO;
    }

    private SsoUserDTO handleUnauthorized(HttpServletResponse response) {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        throw BizException.of(SystemErrorCode.UNAUTHORIZED);
    }

    private Authentication findAuthAnnotation(HandlerMethod handlerMethod) {
        Authentication annotation = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), Authentication.class);
        return (annotation != null) ? annotation : AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), Authentication.class);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        AuthContextHolder.clear();
    }
}
