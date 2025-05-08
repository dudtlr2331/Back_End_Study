package org.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
//@RestController
public class Web04Application {

    public static void main(String[] args) {
        SpringApplication.run(Web04Application.class, args);
    }


    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "Hello Spring Boot!";
    }

    //paramter
//    @RequestMapping("/hello1")
    //url
    @RequestMapping("/hello1.do")
    @ResponseBody
    public String hello1(){
        return "Hello hello2";
    }

//    @RequestMapping("/hello2")
    @RequestMapping("/hello2.do")
    public String hello2(){
        return "Hello hello2";
    }
}
