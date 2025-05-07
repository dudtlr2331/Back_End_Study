package org.example.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot01Application implements CommandLineRunner {

    @Value("${my.name}")
    private String name;

    @Value("${my.fullName}")
    private String fullName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${my.fullName2}")
    private String fullName2;

    public static void main(String[] args) {
        SpringApplication.run(Boot01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello Spring Boot");

        System.out.println("name : " + name);
        System.out.println("fullName : " + fullName);
        System.out.println("fullName2 : " + fullName2);

        System.out.println("url : " + url );
    }
}
