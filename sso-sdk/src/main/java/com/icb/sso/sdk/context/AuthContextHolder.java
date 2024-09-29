package com.icb.sso.sdk.context;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.icb.common.error.SystemErrorCode;
import com.icb.common.exceptions.AuthException;
import com.icb.sso.api.entity.SsoUserDTO;
import lombok.extern.slf4j.Slf4j;
import java.util.Optional;

/**
 * @Description: 用户上下文
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 上午11:49 2023/7/2
 */
@Slf4j
public class AuthContextHolder {

    private static final ThreadLocal<SsoUserDTO> AUTH_CONTEXT = new TransmittableThreadLocal<>();

    public static void bind(SsoUserDTO ssoUserBO) {
        AUTH_CONTEXT.set(ssoUserBO);
        log.debug("Auth Context 绑定成功：{}", ssoUserBO);
    }

    public static void clear() {
        AUTH_CONTEXT.remove();
    }

    public static SsoUserDTO getSsoUser() {
        Optional<SsoUserDTO> optional = Optional.ofNullable(AUTH_CONTEXT.get());
        if (!optional.isPresent()) {
            log.error("通过上下文未获取到用户信息,Thread = {}",Thread.currentThread().getName());
            throw AuthException.of(SystemErrorCode.UNAUTHORIZED);
        }
        return optional.get();
    }
}
