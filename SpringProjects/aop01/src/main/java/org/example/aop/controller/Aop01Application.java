package org.example.aop.controller;

import org.example.aop.model.Action;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;

@SpringBootApplication
public class Aop01Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Aop01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        GenericXmlApplicationContext ctx
                = new GenericXmlApplicationContext("classpath:context.xml");

//        System.out.println("전처리");

//        Action action = (Action) ctx.getBean("writeAction");
        Action action = (Action) ctx.getBean("proxy1");
        action.execute();
        action.execute1();
        action.execute2();

//        System.out.println("후처리");

        ctx.close();

    }
}
