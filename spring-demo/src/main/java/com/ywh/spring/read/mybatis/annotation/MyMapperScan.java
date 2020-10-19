package com.ywh.spring.read.mybatis.annotation;

import com.ywh.spring.read.mybatis.config.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author : yanwenhui
 * @description :
 * @date : 2020/10/16
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportBeanDefinitionRegistrar.class)
public @interface MyMapperScan {

	String[] value() default {};

	String[] basePackages() default {};
}
