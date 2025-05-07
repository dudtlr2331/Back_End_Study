package org.example1.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig2 {

    public BeanConfig2() {
        System.out.println("BeanConfig2() 호출");
    }
}
