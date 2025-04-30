package org.example.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class BasicAdvice1 implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        //전처리 구간
        System.out.println("전처리 구간 1");

        //모니터링 위한 실행속도

        String methodName = invocation.getMethod().getName();
        System.out.println(methodName + " 실행 속도 측정 시작");

        StopWatch stopWatch = new StopWatch();
        stopWatch.start(methodName);

        Object returnObj = invocation.proceed();

        //후처리 구간
        System.out.println("후처리 구간 1");

        stopWatch.stop();
        System.out.println("처리시간 : " + stopWatch.getTotalTimeMillis());

        return returnObj;
    }
}
