package com.ywh.spring.read.mybatis;

import com.ywh.spring.read.aop.service.CglibUserService;
import com.ywh.spring.read.mybatis.annotation.MySelect;
import com.ywh.spring.read.mybatis.useMybatis.mapper.UserMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author :  yanwenhui
 * @date : 2020/7/3
 */
public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");

		userMapper.getUser();

	}
}