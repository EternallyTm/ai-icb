package com.icb.mdm.service;


import com.icb.mdm.bo.UserBO;

public interface UserService {

    /**
     * 根据主键获取用户信息
     * @param userId
     * @return
     */
    UserBO selectById(Long userId);
}
