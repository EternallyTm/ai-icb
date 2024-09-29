package com.icb.sso.api;

import com.icb.sso.api.entity.CheckPermissionDTO;
import com.icb.sso.api.entity.SsoUserDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/sso/inner/v1/")
public interface LoginFacade {

    /**
     * 根据token获取登录用户信息
     * @param token
     * @return
     */
    @GetMapping("/getUserByToken")
    SsoUserDTO getUserByToken(@RequestParam("token") String token);

    /**
     * 用户权限检测
     * @param checkPermissionDTO
     * @return
     */
    @PostMapping("/checkPermission")
    Boolean checkPermission(@Validated @RequestBody CheckPermissionDTO checkPermissionDTO);

}
