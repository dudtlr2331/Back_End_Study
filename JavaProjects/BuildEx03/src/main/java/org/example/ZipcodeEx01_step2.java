package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ZipcodeEx01_step2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/project";
        String username = "project";
        String password = "123456";

        //파일 읽어오기
        BufferedReader br = null;

        Connection conn = null;
        Statement stmt = null;

        try {
            br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();

            String line = "";
            while((line = br.readLine()) != null){
//                System.out.println(line);

                String [] address = line.split(",");
                String sql = String.format("insert into zipcode values ('%s','%s','%s','%s','%s','%s',%s)",
                        address[0], address[1], address[2], address[3], address[4], address[5], address[6]);

                stmt.executeUpdate(sql);
            }
            System.out.println("저장완료");

        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println("[에러]" + e.getMessage());
        }finally {
            if(br != null) try{ br.close(); } catch(IOException e){}
            if(stmt != null) try{ stmt.close(); } catch(SQLException e){}
            if(conn != null) try{ conn.close(); } catch(SQLException e){}
        }
    }
}
