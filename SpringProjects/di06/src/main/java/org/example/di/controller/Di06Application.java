package org.example.di.controller;

import org.example.di.config.BeanConfig;
import org.example.di.model1.Hello;
import org.example.di.model1.HelloBean1;
import org.example.di.model1.HelloBean2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Di06Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Di06Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(BeanConfig.class);

        HelloBean1 helloBean1 = (HelloBean1) ctx.getBean("helloBean1");
        helloBean1.sayHello("홍길동");

        HelloBean2 helloBean2 = (HelloBean2) ctx.getBean("helloBean2");
        helloBean2.sayHello("장길산");

        Hello hello = (Hello) ctx.getBean("hello1");
        hello.sayHello("홍길동");
        hello = (Hello) ctx.getBean("hello2");
        hello.sayHello("장길산");

        HelloBean1 helloBean3 = (HelloBean1) ctx.getBean("helloBean");
        helloBean3.sayHello("임꺽정");

        ctx.close();
    }
}
