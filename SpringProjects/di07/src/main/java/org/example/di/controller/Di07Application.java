package org.example.di.controller;

import org.example.di.config.BeanConfig;
import org.example.di.model.HelloBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Di07Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Di07Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(BeanConfig.class);

        HelloBean helloBean2 = (HelloBean) ctx.getBean("helloBean2");

        ctx.close();
    }
}
