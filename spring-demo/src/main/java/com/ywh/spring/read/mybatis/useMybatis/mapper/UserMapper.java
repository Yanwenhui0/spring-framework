package com.ywh.spring.read.mybatis.useMybatis.mapper;

import com.ywh.spring.read.mybatis.annotation.MySelect;
import org.springframework.stereotype.Component;

/**
 * @author : yanwenhui
 * @description :
 * @date : 2020/10/16
 */
//@Component
public interface UserMapper {

	@MySelect("select * from t_user where name='yanwenhui' ")
	default void getUser(){
		System.out.println("===userMapper===");
	}

}
