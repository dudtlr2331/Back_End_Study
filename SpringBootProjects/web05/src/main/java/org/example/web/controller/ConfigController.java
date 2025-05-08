package org.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfigController {

    @RequestMapping("/")
    public String index() {
        System.out.println("index 호출");
        return "index.html";
    }

    @RequestMapping("/hello1.do")
    public String hello1() {
        return "hello1.html";
    }

    /*@RequestMapping("/hello2.do")
    public String hello2() {
        return "hello2.html";
    }*/

    @RequestMapping("/hello2.do")
    public ModelAndView hello2() {
//        return new ModelAndView("hello2.html");

        ModelAndView modelAndView = new ModelAndView("hello2.html");
        return modelAndView;
    }

    @RequestMapping("/index.do")
    public String index2() {
        return "index";
    }
}
