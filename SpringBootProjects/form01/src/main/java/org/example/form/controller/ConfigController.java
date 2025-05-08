package org.example.form.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfigController {

    @RequestMapping("/form.do")
    public String form() {
        return "form";
    }

    /*@RequestMapping("/form_ok.do")
//    public String form_ok(HttpServletRequest req) {
//    public String form_ok(HttpServletRequest req, Model model) {
    public String form_ok(Model model, HttpServletRequest req) {
//        System.out.println("data1 : " + req.getParameter("data1"));
//        System.out.println("data2 : " + req.getParameter("data2"));

        String data1 = req.getParameter("data1");
        String data2 = req.getParameter("data2");

//        req.setAttribute("data1", data1);
//        req.setAttribute("data2", data2);

        model.addAttribute("data1", data1);
        model.addAttribute("data2", data2);

        return "form_ok";
    }*/

    /*@RequestMapping("/form_ok.do")
//    public String form_ok(@RequestParam String data1, @RequestParam String data2, Model model) {
    public String form_ok(String data1, String data2, Model model) {
        model.addAttribute("data1", data1);
        model.addAttribute("data2", data2);
        return "form_ok";
    }*/

    @RequestMapping("/form_ok.do")
    public ModelAndView form_ok(HttpServletRequest req) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("form_ok");
        modelAndView.addObject("data1",req.getParameter("data1"));
        modelAndView.addObject("data2",req.getParameter("data2"));

        return modelAndView;
    }
}
