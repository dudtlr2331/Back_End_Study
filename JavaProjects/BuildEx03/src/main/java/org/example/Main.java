package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample";
        String username = "root";
        String password = "victory123";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 로딩 성공");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("데이터베이스 연결 성공");
            stmt = conn.createStatement();

            String sql = "select deptno, dname, loc from dept";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String data = String.format("%s\t%s\t%s\n",
                        rs.getString("deptno"), rs.getString("dname"),
                        rs.getString("loc"));

                System.out.println(data);
            }

            System.out.println("데이터베이스 연결 성공");

        } catch (ClassNotFoundException e) {
            System.out.println("[에러] " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if(conn != null) try { conn.close(); } catch (SQLException e) {}
        }
    }
}