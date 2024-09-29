package com.icb.sso.sdk.config;

import com.icb.sso.sdk.inteceptors.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午12:38 2023/7/1
 */
@Configuration
@Order(1)
public class AuthWebConfigure implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;
    private static String[] EXCLUDE_PATH_PATTERNS = {"/swagger**/**","/webjars/**","/v3/**","/doc.html"};
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求
        registry.addInterceptor(authInterceptor).addPathPatterns("/**")
                // 排除swagger 的请求
                .excludePathPatterns(EXCLUDE_PATH_PATTERNS);
    }
}
