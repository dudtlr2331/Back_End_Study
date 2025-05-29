package org.example.zipcode.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.zipcode.dao.ZipcodeDAO;
import org.example.zipcode.dto.ZipcodeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ZipcodeController {

    @Autowired
    private ZipcodeDAO dao;

    @RequestMapping("/zipcode")
    public String listZipcode(){
        return "zipcode";
    }

    @RequestMapping("/zipcode_ok")
    public String zipcode_ok(Model model, HttpServletRequest request) {
        List<ZipcodeTO> lists = dao.listZipcode(request.getParameter("dong"));
        model.addAttribute("lists", lists);
        return "zipcode_ok";
    }
}