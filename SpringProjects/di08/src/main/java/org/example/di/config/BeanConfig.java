package org.example.di.config;

import org.example.di.model1.HelloBean;
import org.springframework.context.annotation.Bean;

public class BeanConfig {

    @Bean
    public HelloBean helloBean1() {
        // 디폴트 생성자
        return new HelloBean();
    }

    @Bean
    public HelloBean helloBean2() {
        return new HelloBean("장길산");
    }
}
