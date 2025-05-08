package org.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Web01Application {

    public static void main(String[] args) {
        SpringApplication.run(Web01Application.class, args);
    }


    @RequestMapping("/")
    public String index() {
        return "<b>Hello World</b>";
    }

    @RequestMapping("/hello1")
    public String hello1() {
        return "<b>Hello hello1</b>";
    }

    @RequestMapping("/hello2")
    public String hello2() {
        return "<b>Hello hello2</b>";
    }
}
