package org.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
//@Controller
public class Web02Application {

    public static void main(String[] args) {
        SpringApplication.run(Web02Application.class, args);
    }

//    @RequestMapping("/hello1")
//    public String hello1() {
//        return "hello1";
//    }
//
//    @RequestMapping("/hello2")
//    public String hello2() {
//        return "hello2";
//    }
}
