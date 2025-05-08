package org.example.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;

@Controller
public class JdbcController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/jdbc.do")
    public String jdbc() {

        System.out.println("dataSource : " + dataSource);
        System.out.println("jdbcTemplate : " + jdbcTemplate);

        String result = jdbcTemplate.queryForObject("select now() as now", String.class);
        System.out.println("현재시간 : " + result);

        return "jdbc";
    }
}
