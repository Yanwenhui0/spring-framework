package com.ywh.spring.read.mybatis.config;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @author : yanwenhui
 * @description :
 * @date : 2020/10/18
 */
public class MybatisFactoryBean<T> implements FactoryBean<T> {

	private Class<T> mapper;

	MybatisFactoryBean(Class<T> mapper) {
		this.mapper = mapper;
	}

	@Override
	public T getObject() throws Exception {
		return (T) Proxy.newProxyInstance(MybatisFactoryBean.class.getClassLoader(), new Class[]{mapper}, new MyInvocationHandler());
	}

	@Override
	public Class<?> getObjectType() {
		return this.mapper;
	}
}
