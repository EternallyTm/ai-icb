package com.icb.sso.service.impl;

import cn.hutool.json.JSONUtil;
import com.icb.common.error.SystemErrorCode;
import com.icb.common.exceptions.AuthException;
import com.icb.sso.bo.SsoUserBO;
import com.icb.sso.bo.UserAuthBO;
import com.icb.sso.service.SsoCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Service
public class SsoCacheServiceImpl implements SsoCacheService {

    private static final String SSO_USER_PREFIX = "sso:user:";
    private static final String USER_AUTH = SSO_USER_PREFIX + "auth:";
    private static final String USER_LOGIN = SSO_USER_PREFIX + "token:";

    @Value("${sso.auth.timeout:30}")
    private Integer authTimeout;

    @Value("${sso.login.token.ttl:60}")
    private Long loginTtl;

    @Value("${sso.login.token.remember-me-ttl:10080}")
    private Long loginRememberMeTtl;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void saveUserAuthCache(UserAuthBO userAuthBO) {
        String jsonStr = JSONUtil.toJsonStr(userAuthBO);
        String key = USER_AUTH + userAuthBO.getUserId();
        redisTemplate.opsForValue().set(key, jsonStr,Duration.ofMinutes(authTimeout));
    }

    @Override
    public UserAuthBO getAuthCache(Long userId) {
        String key = USER_AUTH + userId;
        if (redisTemplate.hasKey(key)) {
            String authJsonStr = redisTemplate.opsForValue().get(key);
            return JSONUtil.toBean(authJsonStr, UserAuthBO.class);
        }
        return null;
    }

    @Override
    public void clearAuthCache(Long userId) {
        String key = USER_AUTH + userId;
        redisTemplate.delete(key);
    }

    @Override
    public SsoUserBO validOrRenewToken(String token) {
        String key = USER_LOGIN + token;
        if (!redisTemplate.hasKey(key)) {
            throw AuthException.of(SystemErrorCode.UNAUTHORIZED);
        }
        String ssoUserStr = redisTemplate.opsForValue().get(key);
        SsoUserBO ssoUserBO = JSONUtil.toBean(ssoUserStr, SsoUserBO.class);
        Long expire = redisTemplate.getExpire(key, TimeUnit.MINUTES);
        // 如果过期时间小于15分钟，则做续期
        if (isShorterThan(expire,15L)) {
            redisTemplate.expire(key,Duration.ofMinutes(loginTtl));
        }
        return ssoUserBO;
    }

    @Override
    public SsoUserBO invalidLoginToken(String token) {
        String key = USER_LOGIN + token;
        if (redisTemplate.hasKey(key)) {
            String ssoUserStr = redisTemplate.opsForValue().get(key);
            return JSONUtil.toBean(ssoUserStr, SsoUserBO.class);
        }
        return null;
    }

    @Override
    public void buildLoginCache(SsoUserBO ssoUserBO, String token, Boolean autoLogin) {
        String key = USER_LOGIN + token;
        String ssoStr = JSONUtil.toJsonStr(ssoUserBO);
        redisTemplate.opsForValue()
                .set(key, ssoStr, autoLogin ? Duration.ofMinutes(loginRememberMeTtl) :  Duration.ofMinutes(loginTtl));
    }

    public static boolean isShorterThan(Long expire, Long threshold) {
        return expire < threshold;
    }
}
