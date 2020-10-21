package com.iqvia.springaopdemo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class); 
	
	//ADVICE
	@Before("execution(* com.iqvia.springaopdemo.ProductService.addProduct(..))")
	public void logBeforeAddingProduct() {
		
		LOGGER.info("Product is being added to DB");
		
	}

	@After("execution(* com.iqvia.springaopdemo.ProductService.placeOrder(..))")
	public void logAfterPlacingOrder(JoinPoint joinpoint) {
		LOGGER.info("Order placed" + joinpoint.getSignature().getDeclaringTypeName());
	}
	
	
}
