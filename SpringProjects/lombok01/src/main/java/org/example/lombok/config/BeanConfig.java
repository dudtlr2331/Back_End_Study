package org.example.lombok.config;

import org.example.lombok.model.HelloBean1;
import org.example.lombok.model.HelloBean2;
import org.springframework.context.annotation.Bean;

public class BeanConfig {

    @Bean
    public HelloBean1 helloBean1(){
        return new HelloBean1("홍길동");
    }

    @Bean
    public HelloBean2 helloBean2(){
        return new HelloBean2("임꺽정");
    }
}
