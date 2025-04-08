package jdbc1;

import java.sql.*;

public class JDBCEx09 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample";
        String user = "root";
        String password = "victory123";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 드라이버 로딩
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 로딩 성공");

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("데이터베이스 연결 성공");

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "select empno, ename, sal, hiredate from emp";
            rs = stmt.executeQuery(sql);

            rs.absolute(1);

            String data = String.format("%s\t%s\t%s\t%s\n",
                    rs.getString("empno"), rs.getString("ename"),
                    rs.getString("sal"), rs.getString("hiredate").replaceAll("-", "/"));
            System.out.println(data);

            rs.absolute(5);

            data = String.format("%s\t%s\t%s\t%s\n",
                    rs.getString("empno"), rs.getString("ename"),
                    rs.getString("sal"), rs.getString("hiredate").replaceAll("-", "/"));
            System.out.println(data);

            rs.absolute(1);

            data = String.format("%s\t%s\t%s\t%s\n",
                    rs.getString("empno"), rs.getString("ename"),
                    rs.getString("sal"), rs.getString("hiredate").replaceAll("-", "/"));
            System.out.println(data);

            //데이터 갯수
            rs.last();
            System.out.println("데이터의 개수 : " + rs.getRow());

            /* while (rs.next()) {
                String data = String.format("%s\t%s\t%s\t%s\n",
                        rs.getString("empno"), rs.getString("ename"),
                        rs.getString("sal"), rs.getString("hiredate").replace("-", "/"));

                System.out.println(data);
            }*/

            System.out.println("실행 성공");

        }catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패 : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러] : " + e.getMessage());
        } finally { // 반드시 연결했으면 해제까지...
            if (conn != null) try{ conn.close(); } catch (SQLException e) {}
            if (stmt != null) try{ stmt.close(); } catch (SQLException e) {}
            if (rs != null) try{ rs.close(); } catch (SQLException e) {}
        }
    }
}
