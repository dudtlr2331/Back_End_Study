package jdbc1;

import java.sql.*;

public class JDBCEx14 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample";
        String user = "root";
        String password = "victory123";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            String sql = "select * from emp";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            ResultSetMetaData rsmd = pstmt.getMetaData();
            System.out.println(rsmd.getColumnCount());
            System.out.println(rsmd.getTableName(1));   // 컬럼 순서는 1부터 시작한다.

            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println(rsmd.getColumnName(i));
                System.out.println(rsmd.getColumnTypeName(i));

                //정수
                System.out.println(rsmd.getColumnDisplaySize(i));
                System.out.println(rsmd.getPrecision(i));

                System.out.println(rsmd.getPrecision(i));   //컬럼의 크기
                System.out.println(rsmd.getScale(i));   //소수점

                System.out.println(rsmd.isNullable(i));
                System.out.println(rsmd.isAutoIncrement(i));
            }

        } catch (ClassNotFoundException e) {
            System.out.println("[에러] " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (conn != null) try{ conn.close(); } catch (SQLException e) {}
            if (pstmt != null) try{ pstmt.close(); } catch (SQLException e) {}
            if (rs != null) try{ rs.close(); } catch (SQLException e) {}
        }
    }
}
