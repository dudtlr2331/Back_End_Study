package org.example.di.config;

import org.example.di.model.HelloBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class BeanConfig {

    @Bean
    public HelloBean helloBean1() {
        return new HelloBean();
    }

    @Bean
    @Scope(value = "prototype")
    public HelloBean helloBean2() {
        return new HelloBean();
    }
}
