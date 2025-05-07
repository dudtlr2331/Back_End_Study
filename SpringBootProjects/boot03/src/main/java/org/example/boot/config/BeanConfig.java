package org.example.boot.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    public BeanConfig() {
        System.out.println("BeanConfig() 호출");
    }
}
