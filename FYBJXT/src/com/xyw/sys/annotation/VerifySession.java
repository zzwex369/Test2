package com.xyw.sys.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 是否验证sesion注解
 * 
 * @author wex
 */

@Target({ ElementType.TYPE,ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface VerifySession
{
    /**
     * 模块  暂且不用
     */
    public String title() default "";

    /**
     * 是否验证session 暂且不用
     */
    public boolean isverifySession() default false;
}
