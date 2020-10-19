package com.ywh.spring.read.aop;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author :  yanwenhui
 * @date : 2020/7/3
 */
@Configurable
@ComponentScan("com.ywh.spring.read.aop")
@EnableAspectJAutoProxy
public class AppConfig {
}
