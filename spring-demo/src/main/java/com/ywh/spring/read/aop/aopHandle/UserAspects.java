package com.ywh.spring.read.aop.aopHandle;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author : yanwenhui
 * @description :
 * @date : 2020/10/13
 */
@Aspect
@Component
public class UserAspects {

	@Pointcut("execution(* com.ywh.spring.read.aop.service..*.*(..))")
	public void pointCut(){};

	@Before("pointCut()")
	public void beforeCut() {
		System.out.println("before......");
	}

	@After("pointCut()")
	public void afterCut() {
		System.out.println("after......");
	}

	@Around("pointCut()")
	public Object aroundCut(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("arount......前");
		Object obj = proceedingJoinPoint.proceed();
		System.out.println("arount......后");
		return obj;
	}

	@AfterThrowing("pointCut()")
	public void exceptCut() {
		System.out.println("except......");
	}

	@AfterReturning("pointCut()")
	public void ruturnCut() {
		System.out.println("ruturn......");
	}


}
