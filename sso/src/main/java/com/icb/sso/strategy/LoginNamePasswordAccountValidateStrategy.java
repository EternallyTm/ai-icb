package com.icb.sso.strategy;

import cn.hutool.core.bean.BeanUtil;
import com.icb.common.exceptions.BizException;
import com.icb.dal.entity.Company;
import com.icb.dal.entity.User;
import com.icb.dal.mapper.CompanyMapper;
import com.icb.dal.mapper.UserMapper;
import com.icb.sso.bo.SsoUserBO;
import com.icb.sso.bo.LoginBO;
import com.icb.sso.errors.SsoErrorCode;
import com.icb.sso.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Description:
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午4:11 2023/7/1
 */
@Component("loginNamePasswordLoginStrategy")
public class LoginNamePasswordAccountValidateStrategy implements AccountValidateStrategy {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CompanyMapper companyMapper;


    @Override
    public SsoUserBO validate(LoginBO model) {
        // 查询用户信息并验证密码正确
        User user = userMapper.findByUsername(model.getUsername());
        if (Objects.isNull(user)) {
            throw BizException.of(SsoErrorCode.INVALID_PASSWORD_OR_LOGIN_NAME);
        }
        String password = model.getPassword();
        boolean isMatch = PasswordUtils.isMatch(password, user.getPassword());
        if (!isMatch) {
            throw BizException.of(SsoErrorCode.INVALID_PASSWORD_OR_LOGIN_NAME);
        }
        SsoUserBO ssoUserBO = BeanUtil.toBean(user, SsoUserBO.class);
        // 如果当前账号存在companyId,则维护companyName
        Long companyId = user.getCompanyId();
        Company company = companyMapper.selectById(companyId);
        if (Objects.nonNull(company)) {
            ssoUserBO.setCompanyName(company.getName());
            ssoUserBO.setCompanyStatus(company.getStatus());
        }
        return ssoUserBO;
    }
}
