package com.ywh.spring.read.mybatis.config;

import com.ywh.spring.read.mybatis.Main;
import com.ywh.spring.read.mybatis.annotation.MySelect;
import com.ywh.spring.read.mybatis.useMybatis.mapper.UserMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author : yanwenhui
 * @description :
 * @date : 2020/10/16
 */
//@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	/**
	 * 问题：
	 * 1、@Component 需要被 spring 扫描到，让业务代码扫描框架 jar 包不合理
	 * 2、无法获取 @MyMapperScan 的扫描包进行多bean的注册
	 *
	 * @param beanFactory the bean factory used by the application context
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{UserMapper.class}, new MyInvocationHandler());
		beanFactory.registerSingleton("userMapper", userMapper);
	}

}
