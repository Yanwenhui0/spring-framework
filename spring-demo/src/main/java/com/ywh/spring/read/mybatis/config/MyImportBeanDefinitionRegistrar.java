package com.ywh.spring.read.mybatis.config;

import com.ywh.spring.read.mybatis.Main;
import com.ywh.spring.read.mybatis.annotation.MyMapperScan;
import com.ywh.spring.read.mybatis.useMybatis.mapper.UserMapper;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : yanwenhui
 * @description :
 * @date : 2020/10/16
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		AnnotationAttributes mapperScanAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(MyMapperScan.class.getName()));
		String scanPackage = mapperScanAttrs.getStringArray("value")[0];

		MyClassPathBeanDefinitionScanner scanner = new MyClassPathBeanDefinitionScanner(registry);
		Set<BeanDefinitionHolder> beanDefinitionHolders = scanner.doScan(scanPackage);

		for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
			GenericBeanDefinition beanDefinition = (GenericBeanDefinition)beanDefinitionHolder.getBeanDefinition();

			beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
			beanDefinition.setBeanClass(MybatisFactoryBean.class);
			registry.registerBeanDefinition(beanDefinitionHolder.getBeanName(), beanDefinition);
		}



	}
}
