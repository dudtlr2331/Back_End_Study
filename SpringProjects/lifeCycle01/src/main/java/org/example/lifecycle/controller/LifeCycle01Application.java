package org.example.lifecycle.controller;

import org.example.lifecycle.config.BeanConfig;
import org.example.lifecycle.model.Action;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LifeCycle01Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LifeCycle01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(BeanConfig.class);

        Action action = (Action) ctx.getBean("writeAction");
        action.execute();

        //빈을 메모리에서 제거
        ctx.removeBeanDefinition("writeAction");

        //스프링 컨테이너 제거
        ctx.close();
    }
}
