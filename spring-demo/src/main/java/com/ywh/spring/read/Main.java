package com.ywh.spring.read;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :  yanwenhui
 * @date : 2020/7/3
 */
public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		People people = applicationContext.getBean(People.class);
		System.out.println(people.toString());
	}
}