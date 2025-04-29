package org.example.di.controller;

import org.example.di.config.BeanConfig;
import org.example.di.config.BeanConfig2;
import org.example.di.model1.HelloBean;
import org.example.di.model2.WriteAction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Di08Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Di08Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(BeanConfig2.class);

//        HelloBean helloBean1 = (HelloBean) ctx.getBean("helloBean1");
//        helloBean1.sayHello();
//        HelloBean helloBean2 = (HelloBean) ctx.getBean("helloBean2");
//        helloBean2.sayHello();

        WriteAction writeAction1 = (WriteAction) ctx.getBean("writeAction1");
        writeAction1.excute();

        WriteAction writeAction2 = (WriteAction) ctx.getBean("writeAction2");
        writeAction2.excute();

        WriteAction writeAction31 = (WriteAction) ctx.getBean("writeAction31");
        writeAction31.excute();

        WriteAction writeAction32 = (WriteAction) ctx.getBean("writeAction32");
        writeAction32.excute();


        ctx.close();
    }
}
