package com.ywh.spring.read.mybatis.config;

import com.ywh.spring.read.mybatis.annotation.MySelect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : yanwenhui
 * @description :
 * @date : 2020/10/16
 */
public class MyInvocationHandler implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		MySelect mySelect = method.getAnnotation(MySelect.class);
		String selectSql = mySelect.value()[0];
		System.out.println(selectSql);
		return null;
	}
}
