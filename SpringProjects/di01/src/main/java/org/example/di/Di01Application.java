package org.example.di;

import model1.HelloBean1;
import model1.HelloBean2;
import model2.Hello;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Di01Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Di01Application.class, args);

        System.out.println("Spring Boot1");
    }

    @Override
    public void run(String... args) throws Exception {
        // Spring Framework를 통한 java program 실행 위치
        System.out.println("Spring Boot2");
//        System.out.println(args.length);

        HelloBean1 helloBean1 = new HelloBean1();
        HelloBean2 helloBean2 = new HelloBean2();

        helloBean1.sayHello("홍길동");
        helloBean2.sayHello("장길산");

        helloBean1 = null;
        helloBean2 = null;

        Hello hello1 = new model2.HelloBean1();
        Hello hello2 = new model2.HelloBean2();

        hello1.sayHello("홍길동");
        hello2.sayHello("장길산");

        hello1 = null;
        hello2 = null;
    }
}
