package org.example;

import java.io.*;
import java.nio.Buffer;
import java.sql.*;

public class ZipcodeEx01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/project";
        String username = "project";
        String password = "123456";

        Connection conn = null;
        Statement stmt = null;
        BufferedReader br = null;

        String zipcodeData = "";
        String[] zipcodeDataArr = null;

        try {
            br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();

            int seq = 1;
            while ((zipcodeData = br.readLine()) != null) {
                zipcodeDataArr = zipcodeData.split( "," );

                String zipcode = zipcodeDataArr[0];
                String sido = zipcodeDataArr[1];
                String gugun = zipcodeDataArr[2];
                String dong = zipcodeDataArr[3];
                String ri = zipcodeDataArr[4];
                String bunji = zipcodeDataArr[5];

                String sql = String.format(
                        "INSERT INTO zipcode VALUES ('%s', '%s', '%s', '%s', '%s', '%s', %d)",
                        zipcode, sido, gugun, dong, ri, bunji, seq++
                );
                System.out.println(sql);
                stmt.executeUpdate(sql);
            }

        } catch (IOException | SQLException | ClassNotFoundException e) {
            System.out.println("[에러] : " + e.getMessage());
        } finally {
            if ( br != null ) try { br.close(); } catch(IOException e) {}
            if (conn != null) try{ conn.close(); } catch (SQLException e) {}
            if (stmt != null) try{ stmt.close(); } catch (SQLException e) {}
        }

    }
}
