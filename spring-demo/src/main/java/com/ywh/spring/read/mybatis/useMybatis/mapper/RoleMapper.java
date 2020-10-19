package com.ywh.spring.read.mybatis.useMybatis.mapper;

import com.ywh.spring.read.mybatis.annotation.MySelect;
import org.springframework.stereotype.Component;

/**
 * @author : yanwenhui
 * @description :
 * @date : 2020/10/18
 */
//@Component
public interface RoleMapper {

	@MySelect("select * from t_user")
	default void getRole(){
		System.out.println("===roleMapper===");
	}
}
