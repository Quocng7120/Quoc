package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryDataExample {
    public static void main(String[] args) throws ClassNotFoundException,
            SQLException {

        // Lấy ra đối tượng Connection kết nối vào DB.
        Connection connection = ConnectionUtils.getMyConnection();

        // Tạo đối tượng Statement.
        Statement statement = connection.createStatement();

        String sql = "Select AccountID, Email, Username from account";

        // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
        ResultSet rs = statement.executeQuery(sql);

        // Duyệt trên kết quả trả về.
        while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
            int accId = rs.getInt(1);
            String email = rs.getString(2);
            String userName = rs.getString("UserName");
            System.out.println("--------------------");
            System.out.println("EmpId:" + accId);
            System.out.println("EmpNo:" + email);
            System.out.println("EmpName:" + userName);
        }
        // Đóng kết nối
        connection.close();
    }
}
