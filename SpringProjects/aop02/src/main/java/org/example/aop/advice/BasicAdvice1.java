package org.example.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class BasicAdvice1 {

    @Pointcut("execution(public * sayHello(..))")
    public void myTarget(){
    }

    @Around("myTarget()")
    public Object aroundLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = null;

        System.out.println("전처리 구간1");

        obj = joinPoint.proceed();

        System.out.println("후처리 구간1");

        return obj;
    }
}
