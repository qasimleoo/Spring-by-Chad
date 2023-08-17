package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    // setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // Point Cut Declaration
    // for controller pkg
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    // for service pkg
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    // for dao pkg
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDAOPackage(){}

    // Combining Point Cuts
    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow(){}

    // Adding @Before Advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){

        // display method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info(" -----> in @Before: calling the method : " + method);

        // display the arguments of that method
        // get the arguments
        Object[] args = joinPoint.getArgs();

        // loop through and display args
        for(Object arg: args){
            logger.info("---> Argument : " + arg);
        }
    }

    @AfterReturning(value = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){

        // display method we are returning from
        String method = joinPoint.getSignature().toShortString();
        logger.info("---> in @AfterReturning: Calling method : " + method);

        // display data returned
        logger.info("---> Result : " + result);
    }
}
