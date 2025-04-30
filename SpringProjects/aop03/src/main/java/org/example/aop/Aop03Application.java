package org.example.aop;

import org.example.aop.model.Calculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Aop03Application implements CommandLineRunner {

    @Autowired
    private ApplicationContext ctx;

    public static void main(String[] args) {
        SpringApplication.run(Aop03Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Calculate calculate = (Calculate) ctx.getBean("target");
        calculate.doCalculate();
    }
}
