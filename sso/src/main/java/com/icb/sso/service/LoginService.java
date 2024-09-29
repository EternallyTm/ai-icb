package com.icb.sso.service;

import com.icb.sso.bo.CheckUserAuthCodeBO;
import com.icb.sso.bo.SsoUserBO;
import com.icb.sso.bo.UserAuthBO;
import reactor.core.publisher.Mono;

public interface LoginService {

    /**
     * 退出登录
     * @author: wangxing <1028106567@qq.com>
     * @param token 用户token
     * @return
     */
    void logout(String token);

    /**
     * 根据token获取用户信息
     * @author: wangxing <1028106567@qq.com>
     * @param token 登录token
     * @return 登录的用户信息
     */
    SsoUserBO findSsoUserByToken(String token);

    /**
     * 校验用户权限
     * @author: wangxing <1028106567@qq.com>
     * @param checkUserAuthCodeBO 鉴权model
     * @return 是否有权限
     */
    Boolean checkUserAuthByCodes(CheckUserAuthCodeBO checkUserAuthCodeBO);

    /**
     * 构建权限缓存
     * @author: wangxing <1028106567@qq.com>
     * @param userId 用户id
     */
    void buildAuthCache(Long userId);

    UserAuthBO getAuthModel(Long userId);
}
