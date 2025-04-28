package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class DeptEx01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample";
        String username = "root";
        String password = "victory123";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        BufferedWriter bw = null;

        try {
            // 파일 작성 준비
            bw = new BufferedWriter(new FileWriter("./dept.csv"));

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 로딩 성공");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("데이터베이스 연결 성공");
            stmt = conn.createStatement();

            String sql = "select * from dept";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                String data = String.format("%s,%s,%s", deptno, dname, loc);

//                System.out.println(data); // 실행하기 전 테스트용
                // 파일에 쓰기
                bw.write(data + System.lineSeparator());
            }

        }catch (ClassNotFoundException | SQLException | IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            try { if (bw != null) bw.close(); } catch (IOException e) {}
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }

    }
}
