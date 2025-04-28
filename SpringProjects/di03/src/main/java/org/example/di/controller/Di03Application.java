package org.example.di.controller;

import org.example.di.model.HelloBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.GenericXmlApplicationContext;

@SpringBootApplication
public class Di03Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Di03Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        GenericXmlApplicationContext ctx
                = new GenericXmlApplicationContext("classpath:context.xml");

        //싱글톤으로 만들었기 때문에 객체 생성 시점이 미리 만들어졌기 때문에 객체 주소가 같다
        HelloBean helloBean21 = (HelloBean) ctx.getBean("helloBean21");
        HelloBean helloBean22 = (HelloBean) ctx.getBean("helloBean22");
        HelloBean helloBean23 = (HelloBean) ctx.getBean("helloBean21");

        //객체 참조값이 틀림
        System.out.println("helloBean21" + helloBean21);
        System.out.println("helloBean22" + helloBean22);
        System.out.println("helloBean23" + helloBean23);

        // 프로토타입은 객체 생성 시점이 그 때 마다 다르기 때문에 객체 주소값이 다 다르다.
        HelloBean helloBean11 = (HelloBean) ctx.getBean("helloBean11");
        HelloBean helloBean12 = (HelloBean) ctx.getBean("helloBean12");
        HelloBean helloBean13 = (HelloBean) ctx.getBean("helloBean11");

        System.out.println("helloBean11" + helloBean11);
        System.out.println("helloBean12" + helloBean12);
        System.out.println("helloBean13" + helloBean13);


        ctx.close();
    }
}
