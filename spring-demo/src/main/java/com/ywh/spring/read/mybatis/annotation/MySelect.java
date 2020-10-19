package com.ywh.spring.read.mybatis.annotation;

import java.lang.annotation.*;

/**
 * @author : yanwenhui
 * @description :
 * @date : 2020/10/16
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MySelect {

	String[] value() default {};

}
