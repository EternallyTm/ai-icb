package com.icb.mdm.service;

import com.icb.mdm.bo.MenuBO;
import com.icb.mdm.enums.MenuScenesEnum;

import java.util.List;

public interface MenuService {

    /**
     * 获取当前用户在指定场景下的菜单
     * @param userId
     * @param menuScenesEnum
     * @return
     */
    List<MenuBO> selectUserMenus(Long userId, MenuScenesEnum menuScenesEnum);
}
