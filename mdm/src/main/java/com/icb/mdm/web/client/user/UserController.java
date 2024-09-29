package com.icb.mdm.web.client.user;


import cn.hutool.core.bean.BeanUtil;
import com.icb.common.model.ApiResult;
import com.icb.mdm.bo.UserBO;
import com.icb.mdm.service.UserService;
import com.icb.mdm.vo.sso.UserVO;
import com.icb.sso.sdk.annotations.Authentication;
import com.icb.sso.sdk.controller.BaseController;
import com.icb.sso.sdk.enums.AuthMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/client/user/v1")
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Deprecated
    @GetMapping("/user-info")
    @Authentication(mode = AuthMode.ONLY_LOGIN)
    public ApiResult<UserVO> getUserInfo() {
        UserBO userBO = userService.selectById(loginUserId());
        return ApiResult.success(BeanUtil.toBean(userBO,UserVO.class));
    }
}
