package org.example.jdbc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void jdbc(){
        System.out.println("jdbcTemplate : " + jdbcTemplate);

        String now = jdbcTemplate.queryForObject("select now() as now", String.class);
        System.out.println("now : " + now);
    }
}
