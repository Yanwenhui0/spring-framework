package com.ywh.spring.read.aop.service;

import org.springframework.stereotype.Service;

/**
 * @author : yanwenhui
 * @description :
 * @date : 2020/10/12
 */
@Service
public class UserServiceImpl implements UserService {

	@Override
	public void getOne() {
		System.out.println("com.ywh.spring.read.aop.UserDao :: getOne");
	}
}
