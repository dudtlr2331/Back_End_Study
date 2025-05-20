package org.example.restweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackageClasses = org.example.controller.RestController1.class)
public class Restweb01Application {

    public static void main(String[] args) {
        SpringApplication.run(Restweb01Application.class, args);
    }

}
