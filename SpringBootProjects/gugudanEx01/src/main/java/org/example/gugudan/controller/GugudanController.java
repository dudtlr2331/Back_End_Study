package org.example.gugudan.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpResponse;

@Controller
public class GugudanController {

    @RequestMapping("/gugudan.do")
    public String gugudan() {
        return "gugudan";
    }

    @RequestMapping("/gugudan_ok.do")
    public ModelAndView gugudan_ok(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gugudan_ok");
        modelAndView.addObject("startDan", request.getParameter("startDan"));
        modelAndView.addObject("endDan", request.getParameter("endDan"));

        return modelAndView;
    }
}
