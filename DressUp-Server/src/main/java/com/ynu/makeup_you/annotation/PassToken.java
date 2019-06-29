package com.ynu.makeup_you.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created on 2019/6/8 0008
 * BY hujianlong
 * @Target:注解的作用目标
 * @Target(ElementType.TYPE)——接口、类、枚举、注解
 * @Target(ElementType.METHOD)——方法
 * @Retention：注解的保留位置
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}
