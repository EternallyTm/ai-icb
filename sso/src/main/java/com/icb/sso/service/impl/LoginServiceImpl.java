package com.icb.sso.service.impl;

import com.icb.dal.entity.Menu;
import com.icb.dal.entity.RoleMenu;
import com.icb.dal.entity.RoleUser;
import com.icb.dal.mapper.MenuMapper;
import com.icb.dal.mapper.RoleMenuMapper;
import com.icb.dal.mapper.RoleUserMapper;
import com.icb.sso.bo.CheckUserAuthCodeBO;
import com.icb.sso.bo.SsoUserBO;
import com.icb.sso.bo.UserAuthBO;
import com.icb.sso.service.SsoCacheService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.icb.sso.service.LoginService;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService{

    @Autowired
    private SsoCacheService ssoCacheService;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;


    @Override
    public void logout(String token) {
        // 删除登录态token
        SsoUserBO ssoUserBO = ssoCacheService.invalidLoginToken(token);
        // 如果登录态不为空，清除权限缓存
        if (Objects.nonNull(ssoUserBO)) {
            ssoCacheService.clearAuthCache(ssoUserBO.getId());
        }
    }

    @Override
    public SsoUserBO findSsoUserByToken(String token) {
        return ssoCacheService.validOrRenewToken(token);
    }

    @Override
    public Boolean checkUserAuthByCodes(CheckUserAuthCodeBO checkUserAuthCodeBO) {
        // 获取用户权限
        UserAuthBO userAuthBO = getAuthModel(checkUserAuthCodeBO.getUserId());
        if (Objects.isNull(userAuthBO) || CollectionUtils.isEmpty(userAuthBO.getPermissionCodes())) {
            return false;
        }
        return doCheckPermission(userAuthBO.getPermissionCodes(), checkUserAuthCodeBO.getAuthCodes());
    }

    private boolean doCheckPermission(List<String> permissionCodes, List<String> authCodes) {
        // 两个集合都为空，错误逻辑，直接返回无权限
        if (CollectionUtils.isEmpty(permissionCodes) || CollectionUtils.isEmpty(authCodes)) {
            return false;
        }
        return authCodes.stream().anyMatch(permissionCodes::contains);
    }

    @Override
    public void buildAuthCache(Long userId) {
        UserAuthBO userAuthBO = buildAuthModel(userId);
        ssoCacheService.saveUserAuthCache(userAuthBO);
    }


    private UserAuthBO buildAuthModel(Long userId) {
        UserAuthBO userAuthBO = new UserAuthBO();
        userAuthBO.setUserId(userId);
        List<RoleUser> roleUsers = roleUserMapper.selectByUserId(userId);
        if (CollectionUtils.isEmpty(roleUsers)) {
            return userAuthBO;
        }
        List<Long> roleIds = roleUsers.stream().map(RoleUser::getRoleId).distinct().toList();
        List<RoleMenu> roleMenus = roleMenuMapper.selectBatchRoleIds(roleIds);
        if (CollectionUtils.isEmpty(roleMenus)) {
            return userAuthBO;
        }
        List<Long> menuIds = roleMenus.stream().map(RoleMenu::getMenuId).distinct().toList();
        List<Menu> menus = menuMapper.selectBatchIds(menuIds);
        if (CollectionUtils.isEmpty(menus)) {
            return userAuthBO;
        }
        List<String> allPerms = menus.stream()
                .map(Menu::getPerms)
                .filter(StringUtils::isNoneBlank)
                .map(perms -> perms.split(","))
                .flatMap(Arrays::stream)
                .distinct()
                .toList();
        userAuthBO.setPermissionCodes(allPerms);
        return userAuthBO;
    }

    @Override
    public UserAuthBO getAuthModel(Long userId) {
        UserAuthBO authCache = ssoCacheService.getAuthCache(userId);
        if (Objects.isNull(authCache)) {
            synchronized (this) {
                authCache = ssoCacheService.getAuthCache(userId);
                if (Objects.isNull(authCache)) {
                    authCache = buildAuthModel(userId);
                    ssoCacheService.saveUserAuthCache(authCache);
                }
            }
        }
        return authCache;
    }
}
