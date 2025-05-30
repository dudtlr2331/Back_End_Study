package org.example.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.thymeleaf.dto.MemberTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class ThymeleafController {

    @RequestMapping("/view1")
    public String view1(HttpServletRequest request, Model model) {

//        request.setAttribute("data","value");
//        request.setAttribute("data","<b>값 값 값<b>");

        model.addAttribute("data","<b>값 값 값<b>");

        return "view1";
    }

    @RequestMapping("/view2")
    public ModelAndView view2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view2");

        modelAndView.addObject("data", "<b>값 1<b>");

//        return new ModelAndView("view2");
        return modelAndView;
    }

    @RequestMapping("/view3")
    public String view3(Model model) {
        MemberTO to = new MemberTO(1001, "회원 1", 26);
        model.addAttribute("to", to);

        return "view3";
    }

    @RequestMapping("/view4")
    public String view4(Model model) {
        model.addAttribute("name", "홍길동");
        return "view4";
    }

    @RequestMapping("/view5")
    public String view5(Model model) {
        model.addAttribute("today", Calendar.getInstance());
        return "view5";
    }

    @RequestMapping("/string")
    public String string(Model model) {
        model.addAttribute("str", "Hello Thymeleaf");
        return "string";
    }

    @RequestMapping("/with")
    public String with(Model model) {
        return "with";
    }

    @RequestMapping("/href")
    public String href(Model model) {
        return "href";
    }

    @RequestMapping("/condition1")
    public String condition1(Model model) {
        return "condition1";
    }

    @RequestMapping("/condition2")
    public String condition2(Model model) {
        model.addAttribute("mem1", new MemberTO(1001, "홍길동", 25));
        model.addAttribute("mem2", new MemberTO(1002, "박문수", 20));
        return "condition2";
    }

    @RequestMapping("/loop1")
    public String loop1(Model model) {
        MemberTO to1 = new MemberTO(1001, "홍길동", 25);
        MemberTO to2 = new MemberTO(1002, "박문수", 26);

        List<MemberTO> lists = new ArrayList<MemberTO>();
        lists.add(to1);
        lists.add(to2);

        model.addAttribute("numbers", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        model.addAttribute("lists", lists);
        model.addAttribute("dans", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        model.addAttribute("cols", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        return "loop1";
    }

    @RequestMapping("/gugudan")
    public String gugudan(Model model) {
        model.addAttribute("dans", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        model.addAttribute("cols", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        return "gugudan";
    }
}
