package org.example.autowired;

import org.example.autowired.model2.WriteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Autowired02Application implements CommandLineRunner {

    @Autowired
    private ApplicationContext ctx;

    public static void main(String[] args) {
        SpringApplication.run(Autowired02Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Springboot에 autowired(자동주입) 사용법

        System.out.println("ctx " + ctx);

        WriteAction writeAction = (WriteAction) ctx.getBean("writeAction");
        writeAction.viewDao();
    }
}

