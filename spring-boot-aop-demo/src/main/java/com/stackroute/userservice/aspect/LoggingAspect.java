package com.stackroute.userservice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution (* com.stackroute.userservice.controller.UserController.*(..))")
    public void allControllerMethods() {
        // Pointcut method
    }

    @Before("allControllerMethods()")
    public void beforeAdvice(JoinPoint joinpoint) {

        logger.info("******************@Before***********************");
        logger.info("Method Name: {}", joinpoint.getSignature().getName());
        logger.info("Method Args: {}", Arrays.toString(joinpoint.getArgs()));
        logger.info("***********************************************");

    }

    @After("allControllerMethods()")
    public void afterAdvice(JoinPoint joinpoint) {

        logger.info("******************@After***********************");
        logger.info("Method Name: {}", joinpoint.getSignature().getName());
        logger.info("Method Args: {}", Arrays.toString(joinpoint.getArgs()));
        logger.info("***********************************************");

    }

    @AfterReturning(value = "allControllerMethods()",returning = "result")
    public void afterReturningAdvice(JoinPoint joinpoint, Object result) {

        logger.info("******************@AfterReturning***********************");
        logger.info("Method Name: {}", joinpoint.getSignature().getName());
        logger.info("Method Args: {}", Arrays.toString(joinpoint.getArgs()));
        logger.info("Return Value: {}", result);
        logger.info("***********************************************");

    }

    @AfterThrowing(value = "allControllerMethods()",throwing = "exception")
    public void afterReturningAdvice(JoinPoint joinpoint, Throwable exception) {

        logger.info("******************@AfterReturning***********************");
        logger.info("Method Name: {}", joinpoint.getSignature().getName());
        logger.info("Method Args: {}", Arrays.toString(joinpoint.getArgs()));
        logger.info("Exception: {}", exception);
        logger.info("***********************************************");

    }
}
