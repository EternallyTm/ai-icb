package com.icb.sso.config;

import com.icb.sso.handler.AbstractLoginHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午11:56 2023/7/1
 */
@Configuration
public class LoginChainManager {

    /**
     * 构建第一个登录处理链
     * @author: wangxing <1028106567@qq.com>
     * @param
     * @return
     */
    @Qualifier(value = "validateParamHandler")
    @Autowired
    private AbstractLoginHandler validateParamHandler;

    @Qualifier(value = "validateRiskHandler")
    @Autowired
    private AbstractLoginHandler validateRiskHandler;

    @Qualifier(value = "validateAccountHandler")
    @Autowired
    private AbstractLoginHandler validateAccountHandler;

    @Qualifier(value = "validateStatusHandler")
    @Autowired
    private AbstractLoginHandler validateStatusHandler;

    @Qualifier(value = "buildAuthCacheHandler")
    @Autowired
    private AbstractLoginHandler buildAuthCacheHandler;

    @Qualifier(value = "generateTokenAndCacheHandler")
    @Autowired
    private AbstractLoginHandler generateTokenAndCacheHandler;

    @Bean
    public AbstractLoginHandler firstLoginHandler() {
        AbstractLoginHandler.Builder builder = new AbstractLoginHandler.Builder();
        return builder
                .addHandler(validateParamHandler)
                .addHandler(validateRiskHandler)
                .addHandler(validateAccountHandler)
                .addHandler(validateStatusHandler)
                .addHandler(buildAuthCacheHandler)
                .addHandler(generateTokenAndCacheHandler)
                .build();
    }
}
