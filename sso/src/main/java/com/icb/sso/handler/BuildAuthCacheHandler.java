package com.icb.sso.handler;


/**
 * @Description: 构建权限验证缓存
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午5:02 2023/7/1
 */

import com.icb.sso.bo.SsoLoginResBO;
import com.icb.sso.bo.SsoUserBO;
import com.icb.sso.bo.LoginBO;
import org.springframework.stereotype.Component;

@Component("buildAuthCacheHandler")
public class BuildAuthCacheHandler extends AbstractLoginHandler {


    @Override
    public SsoLoginResBO doHandler(LoginBO model) {
        SsoUserBO ssoUserBO = model.getSsoUserBO();
        // 构建权限缓存
        loginService.buildAuthCache(ssoUserBO.getId());

        if(hasNext()) {
            return next.doHandler(model);
        }
        return null;
    }
}
