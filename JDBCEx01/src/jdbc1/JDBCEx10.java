package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCEx10 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample";
        String user = "root";
        String password = "victory123";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            //String sql = "insert into dept2 values(51,'생산부','부산')";
            // ? -> 값
            String sql = "insert into dept2 values(?,?,?)";

            pstmt = conn.prepareStatement(sql);
            // '는 생각 안 해도 됨
            pstmt.setInt(1, 52);
            pstmt.setString(2, "연구부");
            pstmt.setString(3, "서울");

            pstmt.executeUpdate(); // sql 빠져야된다.

            System.out.println("쿼리 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("[에러] " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }
    }
}
