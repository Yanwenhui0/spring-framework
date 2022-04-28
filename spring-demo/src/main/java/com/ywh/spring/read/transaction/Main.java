package com.ywh.spring.read.transaction;

import com.mysql.cj.jdbc.Driver;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author :  yanwenhui
 * @date : 2020/7/3
 */
public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		CtService ctService = applicationContext.getBean(CtService.class);
		ctService.getOne();

	}

	@Configurable
	@ComponentScan("com.ywh.spring.read.transaction")
	@EnableAspectJAutoProxy
	@EnableTransactionManagement
	static class AppConfig {

		@Bean
		public DataSource dataSource() {

			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost:3306/exam?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC");
			dataSource.setUsername("root");
			dataSource.setPassword("ywh169747");

			return dataSource;
		}

		@Bean
		public TransactionManager transactionManager(DataSource dataSource) {
			return new DataSourceTransactionManager(dataSource);
		}

	}
}


