package com.icb.mdm.web.client.menu;


import cn.hutool.core.bean.BeanUtil;
import com.icb.common.model.ApiResult;
import com.icb.common.utils.TreeUtil;
import com.icb.mdm.bo.MenuBO;
import com.icb.mdm.enums.MenuScenesEnum;
import com.icb.mdm.service.MenuService;
import com.icb.mdm.vo.menu.MenuVO;
import com.icb.sso.sdk.annotations.Authentication;
import com.icb.sso.sdk.controller.BaseController;
import com.icb.sso.sdk.enums.AuthMode;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;


@RequestMapping("/client/menu/v1")
@RestController
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @Deprecated
    @GetMapping("/user-menus")
    @Authentication(mode = AuthMode.ONLY_LOGIN)
    public ApiResult<List<MenuVO>> getUserMenus() {
        List<MenuBO> menuBOS = menuService.selectUserMenus(loginUserId(), MenuScenesEnum.CLIENT);
        if (CollectionUtils.isEmpty(menuBOS)) {
            return ApiResult.success(Collections.emptyList());
        }
        List<MenuVO> menuVOS = BeanUtil.copyToList(menuBOS, MenuVO.class);
        return ApiResult.success(TreeUtil.buildTreeList(menuVOS));
    }
}
