package com.ywh.spring.read.mybatis;

import com.ywh.spring.read.mybatis.annotation.MyMapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author :  yanwenhui
 * @date : 2020/7/3
 */
@Configurable
//@ComponentScan("com.ywh.spring.read.mybatis")
@MyMapperScan("com.ywh.spring.read.mybatis.useMybatis.mapper")
@EnableAspectJAutoProxy
public class AppConfig {
}
