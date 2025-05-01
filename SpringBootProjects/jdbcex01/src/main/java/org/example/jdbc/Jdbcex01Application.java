package org.example.jdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class Jdbcex01Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Jdbcex01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/sample";
        String user = "root";
        String password = "victory123";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            String sql = "select now() as now";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            if(rs.next()){
                System.out.println("현재 시간 : " + rs.getString("now"));
            }


        }catch(ClassNotFoundException e){
            System.out.println("[에러] " + e.getMessage());
        }catch (SQLException e){
            System.out.println("[에러] " + e.getMessage());
        }finally {
            if(rs != null) try { rs.close(); } catch(SQLException e){}
            if(pstmt != null) try { pstmt.close(); } catch(SQLException e){}
            if(conn != null) try { conn.close(); } catch(SQLException e){}
        }
    }
}
