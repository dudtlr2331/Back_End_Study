package org.example.zipcode.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ZipcodeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ArrayList<ZipcodeTO> listZipcode(String strDong){
        String sql = "select zipcode, sido, gugun, dong, ri, bunji, seq from zipcode where dong like ?";
        ArrayList<ZipcodeTO> lists = (ArrayList<ZipcodeTO>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ZipcodeTO.class), strDong);

        return lists;
    }
}
