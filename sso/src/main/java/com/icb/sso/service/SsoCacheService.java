package com.icb.sso.service;

import com.icb.sso.bo.SsoUserBO;
import com.icb.sso.bo.UserAuthBO;
import reactor.core.publisher.Mono;

public interface SsoCacheService {

    /**
     * 保存权限数据
     * @param userAuthBO 权限数据
     * @return 一个表示操作完成的 Mono
     */
    void saveUserAuthCache(UserAuthBO userAuthBO);

    /**
     * 获取用户权限数据
     * @param userId 当前用户的用户Id
     * @return 返回用户权限模型的 Mono
     */
    UserAuthBO getAuthCache(Long userId);

    /**
     * 清除当前用户的权限缓存
     * @param userId 当前用户Id
     * @return 一个表示操作完成的 Mono
     */
    void clearAuthCache(Long userId);

    /**
     * 校验 token 是否有效，如果有效且临近过期则续期
     * @param token 登录 token
     * @return 有效的用户信息模型
     */
    SsoUserBO validOrRenewToken(String token);

    /**
     * 使登录 token 失效
     * @param token 登录 token
     * @return 失效的用户信息模型
     */
    SsoUserBO invalidLoginToken(String token);

    /**
     * 构建登录 token 缓存
     *
     * @param ssoUserBO 用户信息
     * @param token     登录 token
     * @param autoLogin
     * @return
     */
    void buildLoginCache(SsoUserBO ssoUserBO, String token, Boolean autoLogin);
}
