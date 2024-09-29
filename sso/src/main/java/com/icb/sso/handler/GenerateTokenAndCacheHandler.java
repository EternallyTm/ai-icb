package com.icb.sso.handler;



import cn.hutool.core.util.RandomUtil;
import com.icb.sso.bo.SsoLoginResBO;
import com.icb.sso.bo.SsoUserBO;
import com.icb.sso.bo.LoginBO;
import com.icb.sso.service.SsoCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 生成返回参数处理器
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午5:02 2023/7/1
 */

@Component("generateTokenAndCacheHandler")
public class GenerateTokenAndCacheHandler extends AbstractLoginHandler {

    @Autowired
    private SsoCacheService ssoCacheService;

    @Override
    public SsoLoginResBO doHandler(LoginBO model) {
        SsoUserBO ssoUserBO = model.getSsoUserBO();
        String token = RandomUtil.randomString(32);
        // 构建登录缓存并返回登录响应
        ssoCacheService.buildLoginCache(ssoUserBO, token, model.getAutoLogin());
        SsoLoginResBO ssoLoginResBO = new SsoLoginResBO();
        ssoLoginResBO.setToken(token);
        return ssoLoginResBO;
    }
}
