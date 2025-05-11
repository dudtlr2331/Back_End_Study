package org.example.zipcode.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.zipcode.model.ZipcodeDAO;
import org.example.zipcode.model.ZipcodeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class ZipcodeController {

    @Autowired
    ZipcodeDAO dao;

    @RequestMapping("/zipcode.do")
    public String zipcode() {
        return "zipcode";
    }

    @RequestMapping("/zipcode_ok.do")
    public String zipcode_ok(HttpServletRequest req) {

        ArrayList<ZipcodeTO> lists = dao.listZipcode(req.getParameter("strDong"));
        req.setAttribute("lists", lists);

        return "zipcode_ok";
    }

}
