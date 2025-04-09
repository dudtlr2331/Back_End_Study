package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class ZipcodeEx03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/project";
        String username = "project";
        String password = "123456";

        //파일 읽어오기
        BufferedReader br = null;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);

            String sql = "insert into zipcode values (?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            String line = "";
            while((line = br.readLine()) != null){
                String [] address = line.split(",");
                pstmt.setString(1, address[0]);
                pstmt.setString(2, address[1]);
                pstmt.setString(3, address[2]);
                pstmt.setString(4, address[3]);
                pstmt.setString(5, address[4]);
                pstmt.setString(6, address[5]);
                pstmt.setInt(7, Integer.parseInt(address[6]));

                pstmt.executeUpdate();
            }
            System.out.println("저장완료");

        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println("[에러]" + e.getMessage());
        }finally {
            if(br != null) try{ br.close(); } catch(IOException e){}
            if(pstmt != null) try{ pstmt.close(); } catch(SQLException e){}
            if(conn != null) try{ conn.close(); } catch(SQLException e){}
        }
    }
}
