package org.example.lombok.controller;

import org.example.lombok.config.BeanConfig;
import org.example.lombok.model.Hello;
import org.example.lombok.model.HelloBean1;
import org.example.lombok.model.HelloBean2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Lombok01Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Lombok01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(BeanConfig.class);

        Hello hello = (Hello) ctx.getBean("helloBean1");
        hello.sayHello();

        hello = (Hello) ctx.getBean("helloBean2");
        hello.sayHello();
    }
}
