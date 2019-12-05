package com.wjp.aop.annotation;

import java.lang.annotation.*;

/**
 * @author wjp
 * @date 2019/11/14 10:34
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyLog {

    String requestUrl() default "";
}
