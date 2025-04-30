package org.example.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class BasicAdvice2 implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        //전처리 구간
        System.out.println("전처리 구간 2");

        Object returnObj = invocation.proceed();

        //후처리 구간
        System.out.println("후처리 구간 2");

        return returnObj;
    }
}
