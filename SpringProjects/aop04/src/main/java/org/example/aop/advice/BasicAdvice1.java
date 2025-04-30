package org.example.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class BasicAdvice1 {

    @Pointcut("execution(public * sayHello(..))")
    public void myTarget(){
    }

    /*@Around("myTarget()")
    public Object aroundLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = null;

        System.out.println("전처리 구간1");

        obj = joinPoint.proceed();

        System.out.println("후처리 구간1");

        return obj;
    }*/

    @Before("myTarget()")
    public void before(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("before 1 : " + methodName);
    }

    @After("myTarget()")
    public void after(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("after 1 : " + methodName);
    }
}
