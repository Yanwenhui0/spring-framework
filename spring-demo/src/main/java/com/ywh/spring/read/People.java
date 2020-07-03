package com.ywh.spring.read;

import org.springframework.stereotype.Component;

/**
 * @author :  yanwenhui
 * @date : 2020/7/3
 */
@Component
public class People {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
