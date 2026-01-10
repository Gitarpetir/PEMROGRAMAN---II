package dao;

import model.Admin;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {

    public Admin login(String username, String password) {

        String sql = "SELECT * FROM admin_gym WHERE username = ? AND password = ?";

        try (Connection conn = DatabaseUtil.getConnection();
        		PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Admin(
                        rs.getInt("id_admin"),
                        rs.getString("nama_admin"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("shift")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
