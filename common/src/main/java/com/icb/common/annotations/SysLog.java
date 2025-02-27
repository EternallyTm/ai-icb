
package com.icb.common.annotations;

import java.lang.annotation.*;

/**
 * 系统日志注解
 *
 * @author wangxing <1028106567@qq.com>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	String value() default "";
}
