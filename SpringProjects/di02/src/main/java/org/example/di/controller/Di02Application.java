package org.example.di.controller;

import org.example.di.model1.HelloBean1;
import org.example.di.model1.HelloBean2;
import org.example.di.model2.Hello;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

@SpringBootApplication
public class Di02Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Di02Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        // 1. 조립기 불러오기
//        GenericApplicationContext ctx
        GenericXmlApplicationContext ctx
                = new GenericXmlApplicationContext("classpath:context.xml");

//        // 2. 내용
//        HelloBean1 helloBean1
////                = (HelloBean1) ctx.getBean("helloBean1");
//                = ctx.getBean("helloBean1", HelloBean1.class);
//        helloBean1.sayHello("홍길동");
//
//        HelloBean2 helloBean2 = (HelloBean2) ctx.getBean("helloBean2");
//        helloBean2.sayHello("장길산");
//
//        // 3. 마무리
//        ctx.close();

        Hello hello = (Hello) ctx.getBean("hello1");
        hello.sayHello("홍길동");

        hello = (Hello) ctx.getBean("hello2");
        hello.sayHello("장길산");

        // 3. 마무리
        ctx.close();
    }
}
