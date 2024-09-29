package com.icb.mdm.service.impl;
import cn.hutool.core.bean.BeanUtil;
import com.icb.dal.entity.Menu;
import com.icb.dal.entity.RoleMenu;
import com.icb.dal.entity.RoleUser;
import com.icb.dal.mapper.MenuMapper;
import com.icb.dal.mapper.RoleMenuMapper;
import com.icb.dal.mapper.RoleUserMapper;
import com.icb.mdm.bo.MenuBO;
import com.icb.mdm.enums.MenuScenesEnum;
import com.icb.mdm.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
@Slf4j
public class MenuServiceImpl implements MenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuBO> selectUserMenus(Long userId, MenuScenesEnum menuScenesEnum) {
        List<RoleUser> roleUsers = roleUserMapper.selectByUserId(userId);
        if (CollectionUtils.isEmpty(roleUsers)) {
            return Collections.emptyList();
        }
        List<Long> roleIds = roleUsers.stream().map(RoleUser::getRoleId).distinct().toList();
        List<RoleMenu> roleMenus = roleMenuMapper.selectBatchRoleIds(roleIds);
        if (CollectionUtils.isEmpty(roleMenus)) {
            return Collections.emptyList();
        }
        List<Long> menuIds = roleMenus.stream().map(RoleMenu::getMenuId).distinct().toList();
        List<Menu> menus = menuMapper.selectBatchIds(menuIds);
        // 获取所有已分配权限的上级菜单
        List<Long> allParentIds = menus.stream()
                .map(menu -> menu.getCode().split(","))
                .flatMap(Arrays::stream).distinct()
                .map(Long::valueOf)
                .filter(menuId -> !menuIds.contains(menuId))
                .toList();
        List<Menu> allMenus = menuMapper.selectBatchIds(allParentIds);
        menus.addAll(allMenus);
        return BeanUtil.copyToList(menus,MenuBO.class);
    }
}
