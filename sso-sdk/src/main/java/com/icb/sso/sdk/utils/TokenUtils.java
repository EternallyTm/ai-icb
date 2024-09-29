package com.icb.sso.sdk.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import java.util.Map;

public class TokenUtils {

    public static final String AUTH_TOKEN = "auth-token";

    public static final String QUERY_TOKEN = "token";


    /**
     * 从请求中提取token
     *
     * @param request 请求
     * @return token
     */
    public static String extractToken(HttpServletRequest request) {
        String headerToken = extractFromHeader(request);
        if (StringUtils.isNotBlank(headerToken)) {
            return headerToken;
        }
        String bearerToken = extractFromBasicAuthHeader(request);
        if (StringUtils.isNotBlank(bearerToken)) {
            return bearerToken;
        }
        String cookieToken = extractFromCookie(request);
        if (StringUtils.isNotBlank(cookieToken)) {
            return cookieToken;
        }
        String queryParamToken = extractFromQueryParam(request);
        if (StringUtils.isNotBlank(queryParamToken)) {
            return queryParamToken;
        }
        return null;
    }

    private static String extractFromQueryParam(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String[] tokens = parameterMap.get(QUERY_TOKEN);
        if (tokens != null && tokens.length > 0) {
            return tokens[0];
        }
        return null;
    }

    /**
     * 从cookie中提取
     */
    private static String extractFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (StringUtils.equals(cookie.getName(), AUTH_TOKEN)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 从自定义header中提取
     */
    private static String extractFromHeader(HttpServletRequest request) {
        return request.getHeader(AUTH_TOKEN);
    }

    /**
     * 从Basic Auth协议header中提取
     */
    private static String extractFromBasicAuthHeader(HttpServletRequest request) {
        String authToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isNotBlank(authToken)) {
            authToken = StringUtils.substringAfter(authToken, "Bearer ");
        }
        return authToken;
    }
}
