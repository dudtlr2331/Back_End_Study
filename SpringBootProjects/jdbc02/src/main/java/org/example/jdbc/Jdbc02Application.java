package org.example.jdbc;

import org.example.jdbc.model.DateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class Jdbc02Application implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private DateDAO dao;

    public static void main(String[] args) {
        SpringApplication.run(Jdbc02Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello JDBC");

//        System.out.println("dataSource : " + dataSource);
//        System.out.println("dataSource.getConnection() : " + dataSource.getConnection());

        /*Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = dataSource.getConnection();

            String url = "select now() as now";
            pstmt = conn.prepareStatement(url);

            rs = pstmt.executeQuery();

            if(rs.next()){
                System.out.println(rs.getString("now"));
            }
        }catch (SQLException e){
            System.out.println("[에러] " + e.getMessage());
        }finally {
            if(rs != null) try{ rs.close(); } catch(SQLException e){}
            if(pstmt != null) try{ pstmt.close(); } catch(SQLException e){}
            if(conn != null) try{ conn.close(); } catch(SQLException e){}
        }*/

//        DateDAO dao = new DateDAO();
        dao.jdbc();

    }
}
