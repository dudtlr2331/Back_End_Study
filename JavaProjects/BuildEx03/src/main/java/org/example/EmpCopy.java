package org.example;

import java.sql.*;

public class EmpCopy {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample";
        String user = "root";
        String password = "victory123";

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            String sql = "create table emp2 as select * from emp";
            stmt.executeUpdate(sql);

            System.out.println("복사 완료");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (conn != null) try{conn.close();} catch(SQLException e){}
            if (stmt != null) try{stmt.close();} catch(SQLException e){}
        }

    }
}
