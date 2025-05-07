package org.example.jdbc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class DeptDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void listDepts(){
//        List<Map<String, Object>> depts = jdbcTemplate.queryForList("select * from dept");
//        for(Map<String, Object> dept : depts){
//            System.out.println(dept.get("deptno"));
//            System.out.println(dept.get("dname"));
//            System.out.println(dept.get("loc"));
//        }

//        List<DeptTO> results = jdbcTemplate.query("select * from dept", new BeanPropertyRowMapper<>(DeptTO.class));
//        ArrayList<DeptTO> results = (ArrayList<DeptTO>) jdbcTemplate.query("select * from dept", new BeanPropertyRowMapper<>(DeptTO.class));
//        for(DeptTO result : results){
//            System.out.println(result.getDeptno());
//            System.out.println(result.getDname());
//            System.out.println(result.getLoc());
//        }

//        String sql = "select * from dept";
        String sql = "select * from dept where deptno = ?";
        ArrayList<DeptTO> results = (ArrayList<DeptTO>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(DeptTO.class), 20);
        for(DeptTO result : results){
            System.out.println(result.getDeptno());
            System.out.println(result.getDname());
            System.out.println(result.getLoc());
        }

    }
}
