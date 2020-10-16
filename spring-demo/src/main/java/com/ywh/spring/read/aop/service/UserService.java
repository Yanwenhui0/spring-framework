package com.ywh.spring.read.aop.service;


public interface UserService {

	default void getOne() {
		System.out.println("com.ywh.spring.read.aop.UserDao :: getOne");
	}

}
