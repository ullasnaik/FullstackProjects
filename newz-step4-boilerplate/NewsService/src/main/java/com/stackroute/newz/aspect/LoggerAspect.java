package com.stackroute.newz.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/* Annotate this class with @Aspect and @Component */
@Component
@Aspect
public class LoggerAspect {

	/*
	 * Write loggers for each of the methods of NewsController, any particular method
	 * will have all the four aspectJ annotation
	 * (@Before, @After, @AfterReturning, @AfterThrowing).
	 */
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Before("execution(* com.stackroute.newz.*.*(..))")
//	public void before(JoinPoint joinPoint){
//		//Advice
//		logger.info(" Check for user access ");
//		logger.info(" Allowed execution for {}", joinPoint);
//	}
//	@AfterReturning(value = "execution(* com.stackroute.newz.*.*(..))",
//			returning = "result")
//	public void afterReturning(JoinPoint joinPoint, Object result) {
//		logger.info("{} returned with value {}", joinPoint, result);
//	}
//	@After(value = "execution(* com.stackroute.newz.*.*(..))")
//	public void after(JoinPoint joinPoint) {
//		logger.info("after execution of {}", joinPoint);
//	}
//	@AfterThrowing (pointcut = "execution(* com.stackroute.newz.*(..))", throwing = "ex")
//	public void logAfterThrowingAllMethods(Exception ex) throws Throwable  {
//		logger.info("after execution of {}", ex.getMessage());
//	}


}
