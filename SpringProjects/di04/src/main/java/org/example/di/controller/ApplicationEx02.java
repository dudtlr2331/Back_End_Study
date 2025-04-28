package org.example.di.controller;

import org.example.di.model2.WriteAction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;

@SpringBootApplication
public class ApplicationEx02 implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Di04Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        GenericXmlApplicationContext ctx
                = new GenericXmlApplicationContext("classpath:context3.xml");

        WriteAction writeAction3 = (WriteAction) ctx.getBean("listAction");
        writeAction3.execute();

        ctx.close();
    }
}
