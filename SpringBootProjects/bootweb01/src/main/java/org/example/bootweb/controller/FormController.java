package org.example.bootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

    @RequestMapping("/form.do")
    public String form() {
        System.out.println("form() 호출");
        return "form";
    }

//    @RequestMapping("/form_ok.do")
//    public String form_ok() {
//        System.out.println("form_ok() 호출");
//        return "form_ok";
//    }

    @GetMapping("/form_ok.do")
    public String form_get_ok() {
        System.out.println("get 방식 form_ok() 호출");
        return "form_ok";
    }

    @PostMapping("/form_ok.do")
    public String form_post_ok() {
        System.out.println("post 방식 form_ok() 호출");
        return "form_ok";
    }

    @PutMapping("/form_ok.do")
    public String form_put_ok() {
        System.out.println("put 방식 form_ok() 호출");
        return "form_ok";
    }

    @DeleteMapping("/form_ok.do")
    public String form_delete_ok() {
        System.out.println("delete 방식 form_ok() 호출");
        return "form_ok";
    }
}
