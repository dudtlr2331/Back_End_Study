package org.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigController {

    @RequestMapping("/form")
    public String form() {
        return "form";
    }

    @RequestMapping("/form_ok")
    public String form_ok() {
        return "form_ok";
    }
}
