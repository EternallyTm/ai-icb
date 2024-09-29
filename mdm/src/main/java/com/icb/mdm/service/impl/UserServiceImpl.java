package com.icb.mdm.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.icb.dal.entity.Company;
import com.icb.dal.entity.User;
import com.icb.dal.mapper.CompanyMapper;
import com.icb.dal.mapper.UserMapper;
import com.icb.mdm.bo.UserBO;
import com.icb.mdm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;


/**
 * 用户管理service
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public UserBO selectById(Long userId) {
        User user = userMapper.selectById(userId);
        if (Objects.isNull(user)) {
            return null;
        }
        UserBO userBO = BeanUtil.toBean(user, UserBO.class);
        Long companyId = userBO.getCompanyId();
        if (Objects.nonNull(companyId)) {
            Company company = companyMapper.selectById(companyId);
            if (Objects.nonNull(company)){
                userBO.setCompanyName(company.getName()); // 设置公司名称
            }
        }
        return userBO;
    }
}
