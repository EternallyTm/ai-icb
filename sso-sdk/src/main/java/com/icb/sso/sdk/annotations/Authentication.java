package com.icb.sso.sdk.annotations;



import com.icb.sso.sdk.enums.AuthMode;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 上午11:05 2023/7/2
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authentication {

    String[] value() default {};

    @AliasFor("value")
    String[] authCode() default {};

    AuthMode mode() default AuthMode.ONLY_LOGIN;


}
