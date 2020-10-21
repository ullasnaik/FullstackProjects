package com.sr.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeCRUDAspect {
	@Before("execution(* com.sr.dao.EmployeeDao.getEmployeeById(..))")
	public void logBeforeV1(JoinPoint joinpoint) {
	System.out.println("EmployeeCRUDAspect.logBeforeV1() :" 
	                       +joinpoint.getSignature().getName());
	}
	
	@After("execution(* com.sr.dao.EmployeeDao.getEmployeeById(..))")
	public void logAfterV1(JoinPoint joinpoint) {
	System.out.println("EmployeeCRUDAspect.logAfterV1() :" 
	                           +joinpoint.getSignature().getName());
	}
		
	@Before("execution(* com.sr.dao.EmployeeDao.*(..))")
	public void logBeforeV2(JoinPoint joinPoint) {
		System.out.println("EmployeeCRUDAspect.logBeforeV2() :" 
	                           +joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.sr.dao.EmployeeDao.*(..))")
	public void logAfterV2(JoinPoint joinPoint) {
		System.out.println("EmployeeCRUDAspect.logAfterV2() :" 
	                             +joinPoint.getSignature().getName());
	}



}
