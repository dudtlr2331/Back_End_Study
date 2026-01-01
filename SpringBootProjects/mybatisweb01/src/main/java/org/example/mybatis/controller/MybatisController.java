package org.example.mybatis.controller;

import org.example.mybatis.dao.MyBatisDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MybatisController {

    @Autowired
    private MyBatisDAO mybatisDAO;

    @RequestMapping("/mybatis")
    public String mybatis(Model model) {

        model.addAttribute("result", mybatisDAO.select());
        model.addAttribute("resultLists", mybatisDAO.selectList());

        return "mybatis";
    }
}
