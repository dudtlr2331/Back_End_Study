import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class Zipcode {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample";
        String user = "root";
        String password = "victory123";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));

            String addData = null;
            String[] addresses = null;

            // 드라이버 로딩
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 로딩 성공");

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("데이터베이스 연결 성공");

            stmt = conn.createStatement();

            int lineCount = 0;
//            while( ( addData = br.readLine() ) != null ) {
            while((addData = br.readLine()) != null && lineCount < 10) {
                addresses = addData.split( "," );

                String address = String.format( "[%s] %s %s %s %s %s\n",
                        addresses[0], addresses[1], addresses[2],
                        addresses[3], addresses[4], addresses[5] );
                System.out.println(address);

                String zipcode = addresses[0];
                String sido = addresses[1];
                String gugun = addresses[2];
                String dong = addresses[3];
                String ri = addresses[4];
                String bunji = addresses[5];

                String sql = String.format(
                        "INSERT INTO zipcode VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                        zipcode, sido, gugun, dong, ri, bunji
                );
                stmt.executeUpdate(sql);
                lineCount++;
            }
            System.out.println("실행 성공");

        } catch (IOException e) {
            System.out.println( "[에러] " + e.getMessage() );
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패 : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러] : " + e.getMessage());
        } finally {
            if ( br != null ) try { br.close(); } catch(IOException e) {}
            if (conn != null) try{ conn.close(); } catch (SQLException e) {}
            if (stmt != null) try{ stmt.close(); } catch (SQLException e) {}
            if (rs != null) try{ rs.close(); } catch (SQLException e) {}
        }
    }
}
