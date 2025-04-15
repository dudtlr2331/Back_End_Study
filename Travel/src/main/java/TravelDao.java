import java.sql.*;
import java.util.ArrayList;

public class TravelDao {
    private final String url = "jdbc:mysql://localhost:3306/travel_db";
    private final String user = "team1";
    private final String password = "123456";

    public TravelDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로딩 완료");
        } catch (ClassNotFoundException e) {
            System.out.println("[에러] " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public ArrayList<TravelVO> selectTravelAll(int page, int pageSize){
        ArrayList<TravelVO> list = new ArrayList<>();
        String sql = "select * from travel limit ?, ?";

        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, (page - 1) * pageSize);
            pstmt.setInt(2, pageSize);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                TravelVO tvo = new TravelVO();

                tvo.setNo(rs.getInt("no"));
                tvo.setDistrict(rs.getString("district"));
                tvo.setTitle(rs.getString("title"));
                tvo.setDescription(rs.getString("description"));
                tvo.setAddress(rs.getString("address"));
                tvo.setPhone(rs.getString("phone"));

                list.add(tvo);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("[selectTravelAll 에러] " + e.getMessage());
        }

        return list;
    }

    public ArrayList<TravelVO> getByDistrict(String district){
        ArrayList<TravelVO> list = new ArrayList<>();
        String sql = "select * from travel where district = ?";

        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, district);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                TravelVO tvo = new TravelVO();

                tvo.setNo(rs.getInt("no"));
                tvo.setDistrict(rs.getString("district"));
                tvo.setTitle(rs.getString("title"));
                tvo.setDescription(rs.getString("description"));
                tvo.setAddress(rs.getString("address"));
                tvo.setPhone(rs.getString("phone"));

                list.add(tvo);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("[selectTravelAll 에러] " + e.getMessage());
        }

        return list;
    }

    public ArrayList<TravelVO> searchByTitle(String keyword) {
        ArrayList<TravelVO> list = new ArrayList<>();
        String sql = "SELECT * FROM travel WHERE title LIKE ?";

        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "%" + keyword + "%");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                TravelVO tvo = new TravelVO();

                tvo.setNo(rs.getInt("no"));
                tvo.setDistrict(rs.getString("district"));
                tvo.setTitle(rs.getString("title"));
                tvo.setDescription(rs.getString("description"));
                tvo.setAddress(rs.getString("address"));
                tvo.setPhone(rs.getString("phone"));

                list.add(tvo);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("[selectTravelAll 에러] " + e.getMessage());
        }

        return list;
    }
}
