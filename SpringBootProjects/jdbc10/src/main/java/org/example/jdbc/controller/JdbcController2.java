package org.example.jdbc.controller;

import org.example.jdbc.model.JdbcDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;

@Controller
public class JdbcController2 {

    @Autowired
    private JdbcDAO dao;

    @RequestMapping("/dao.do")
    public String dao() {

        dao.jdbc();

        return "jdbc";
    }
}
