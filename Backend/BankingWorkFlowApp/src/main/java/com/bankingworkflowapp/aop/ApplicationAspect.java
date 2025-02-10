package com.bankingworkflowapp.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationAspect {


    @Before("execution(* com.bankingworkflowapp.services.ApplicationServiceImpl.*(..))")
    public void beforeMethod() {
        System.out.println("AOP Before method executed.");
    }

    @After("execution(* com.bankingworkflowapp.services.ApplicationServiceImpl.*(..))")
    public void afterMethod() {
        System.out.println("AOP After method executed.");
    }
    
//    @Around("execution(* com.bankingworkflowapp.services.ApplicationServiceImpl.*(..))")
//    public void exceptionHandling() {
//    	try {
//    		System.out.println("try block from aop");
//    	}catch(NoApplicationFoundException e) {
//				System.out.println(e.getMessage());
//       }catch(Exception e) {
//    		System.out.println(e.getMessage());
//    	}
//    }
}

//
//@RestControllerAdvice
//public class ApplicationAspect {
//	
//	@ExceptionHandler()
//}




















