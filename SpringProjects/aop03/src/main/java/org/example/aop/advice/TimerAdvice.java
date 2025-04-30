package org.example.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class TimerAdvice {

    @Pointcut("execution( public * doCalculate(..))")
    public void myTarget(){

    }

    @Around("myTarget()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = null;

        obj = joinPoint.proceed();

        return obj;
    }
}
