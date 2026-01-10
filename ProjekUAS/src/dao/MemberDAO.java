package dao;

import model.Member;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {

    public void insert(Member m) {
        String sql = "INSERT INTO member (nama_lengkap, alamat, no_telepon) VALUES (?, ?, ?)";

        try (Connection db = DatabaseUtil.getConnection(); 
        		PreparedStatement ps = db.prepareStatement(sql)) {
        	ps.setString(1, m.getNama());
            ps.setString(2, m.getAlamat());
            ps.setString(3, m.getTelepon());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error insert member: " + e.getMessage());
        }
    }

    public void update(Member m) {
        String sql = "UPDATE member SET nama_lengkap=?, alamat=?, no_telepon=? WHERE id_member=?";

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {

            ps.setString(1, m.getNama());
            ps.setString(2, m.getAlamat());
            ps.setString(3, m.getTelepon());
            ps.setInt(4, m.getIdMember());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error update member: " + e.getMessage());
        }
    }

    public void delete(int idMember) {
        String sql = "DELETE FROM member WHERE id_member=?";

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {

            ps.setInt(1, idMember);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error delete member: " + e.getMessage());
        }
    }

    public ArrayList<Member> getAll() {
        String sql = "SELECT * FROM member";
        ArrayList<Member> list = new ArrayList<>();

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql);
        		ResultSet rs = ps.executeQuery()) {
        	
        	while (rs.next()) {
                list.add(new Member(
                        rs.getInt("id_member"),
                        rs.getString("nama_lengkap"),
                        rs.getString("alamat"),
                        rs.getString("no_telepon")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error getAll member: " + e.getMessage());
        }

        return list;
    }

    public Member getById(int idMember) {
    	String sql = "SELECT * FROM member WHERE id_member=?";

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {

            ps.setInt(1, idMember);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Member(
                            rs.getInt("id_member"),
                            rs.getString("nama_lengkap"),
                            rs.getString("alamat"),
                            rs.getString("no_telepon")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Error getById member: " + e.getMessage());
        }

        return null;
    }
}
