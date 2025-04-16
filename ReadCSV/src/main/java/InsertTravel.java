import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTravel {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/travel_db";
        String user = "team1";
        String password = "123456";

        Connection conn = null;
        PreparedStatement pstmt = null;
        CSVReader reader = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO travel (district, title, description, address, phone) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            reader = new CSVReaderBuilder(new FileReader("./travel.csv"))
                    .withSkipLines(1)
                    .build();

            String[] arr;

            while ((arr = reader.readNext()) != null) {
                if (arr.length < 6) continue;

                String district = arr[1].trim();
                String title = arr[2].trim();
                String description = arr[3].trim();
                String address = arr[4].trim();
                String phone = arr[5].trim();

                pstmt.setString(1, district);
                pstmt.setString(2, title);
                pstmt.setString(3, description);
                pstmt.setString(4, address);
                pstmt.setString(5, phone);

                pstmt.executeUpdate();
            }
            System.out.println("데이터 삽입 완료!");

        } catch (IOException | CsvValidationException | ClassNotFoundException | SQLException e) {
            System.out.println("[에러] : " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.out.println("[에러] : " + e.getMessage());
            }
        }
    }
}