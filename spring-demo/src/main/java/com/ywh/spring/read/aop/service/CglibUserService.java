package com.ywh.spring.read.aop.service;

import org.springframework.stereotype.Service;

/**
 * @author : yanwenhui
 * @description :
 * @date : 2020/10/13
 */
@Service
public class CglibUserService {

	public void getOne() {
		System.out.println("com.ywh.spring.read.aop.UserDao :: getOne");
	}

}
