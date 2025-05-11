package org.example.zipcode.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class ZipcodeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    public ArrayList<ZipcodeTO> listZipcode(String strDong){
        String sql = "select zipcode, sido, gugun, dong, ri, bunji, seq from zipcode where dong like ?";
        ArrayList<ZipcodeTO> lists = (ArrayList<ZipcodeTO>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ZipcodeTO.class), "%" + strDong + "%");

        return lists;
    }

    public ArrayList<ZipcodeTO> listZipcode2(String strDong){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<ZipcodeTO> lists = new ArrayList<>();

        try {
            conn = dataSource.getConnection();
            String sql = "select zipcode, sido, gugun, dong, ri, bunji, seq from zipcode where dong like ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, strDong + "%");

            rs = pstmt.executeQuery();


            while (rs.next()) {
                ZipcodeTO to = new ZipcodeTO();

                to.setZipcode(rs.getString("zipcode"));
                to.setSido(rs.getString("sido"));
                to.setGugun(rs.getString("gugun"));
                to.setDong(rs.getString("Dong"));
                to.setRi(rs.getString("ri"));
                to.setBunji(rs.getString("bunji"));

                lists.add(to);
            }

        } catch (SQLException e) {
            System.out.println("[에러]" + e.getMessage());
        }

        return lists;
    }
}
