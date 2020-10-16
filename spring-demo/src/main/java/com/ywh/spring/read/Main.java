package com.ywh.spring.read;

import com.ywh.spring.read.aop.service.CglibUserService;
import com.ywh.spring.read.aop.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :  yanwenhui
 * @date : 2020/7/3
 */
public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

//		People people = applicationContext.getBean(People.class);
//		System.out.println(people.toString());

//		UserService userService = (UserService) applicationContext.getBean(UserService.class);
//		userDao.getOne();

		CglibUserService cglibUserService = (CglibUserService) applicationContext.getBean("cglibUserService");
		cglibUserService.getOne();

	}
}