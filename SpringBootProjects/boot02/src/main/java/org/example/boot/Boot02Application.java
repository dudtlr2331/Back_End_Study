package org.example.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot02Application implements CommandLineRunner {

    @Value("${my.name}")
    private String name;

    @Value("${my.fullname}")
    private String fullname;

    @Value("${spring.datasource.url}")
    private String url;

    public static void main(String[] args) {
        SpringApplication.run(Boot02Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello Spring Boot");

        System.out.println("name : " + name);
        System.out.println("fullname : " + fullname);
        System.out.println("url : " + url);
    }
}
