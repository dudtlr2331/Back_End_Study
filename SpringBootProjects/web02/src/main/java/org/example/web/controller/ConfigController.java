package org.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigController {

    @RequestMapping("/hello1")
    public String hello1() {
        return "hello1";
    }

    @RequestMapping("/hello2")
    public String hello2() {
        return "hello2";
    }
}
