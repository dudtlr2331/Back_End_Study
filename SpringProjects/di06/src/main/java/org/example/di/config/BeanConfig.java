package org.example.di.config;

import org.example.di.model1.Hello;
import org.example.di.model1.HelloBean1;
import org.example.di.model1.HelloBean2;
import org.springframework.context.annotation.Bean;

// POJO 클래스
// 환경설정에 사용되는 클래스
public class BeanConfig {

    @Bean
    public HelloBean1 helloBean1() {
        return new HelloBean1();
    }

    @Bean
    public HelloBean2 helloBean2() {
        return new HelloBean2();
    }

    @Bean
    public Hello hello1() {
        return new HelloBean1();
    }

    @Bean
    public Hello hello2() {
        return new HelloBean2();
    }

    @Bean(name = "helloBean")
    public HelloBean1 helloBean3(){
        return new HelloBean1();
    }
}
