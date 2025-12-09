package dao.impl;

import dao.AkunDao;
import model.Akun;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;

public class AkunImpl implements AkunDao {

    @Override
    public void insert(Akun akun) {
        String sql = "INSERT INTO akun (username, password) VALUES (?,?)";

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {

            ps.setString(1, akun.getUsername());
            ps.setString(2, akun.getPassword());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error insert akun: " + e.getMessage());
        }
    }

    @Override
    public void update(Akun akun) {
        String sql = "UPDATE akun SET username=?, password=? WHERE idAkun=?";

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {

            ps.setString(1, akun.getUsername());
            ps.setString(2, akun.getPassword());
            ps.setInt(3, akun.getIdAkun());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error update akun: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM akun WHERE idAkun=?";

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error delete akun: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Akun> getAll() {
        String sql = "SELECT id, username, password FROM akun";
        ArrayList<Akun> list = new ArrayList<>();

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql);
        		ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String user = rs.getString("username");
                String pass = rs.getString("password");

                list.add(new Akun(id, user, pass));
            }

        } catch (SQLException e) {
            System.out.println("Error getAll akun: " + e.getMessage());
        }

        return list;
    }

    @Override
    public Akun getById(int id) {
        String sql = "SELECT * FROM akun WHERE idAkun=?";

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Akun(
                        rs.getInt("idAkun"),
                        rs.getString("username"),
                        rs.getString("password")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Error getById akun: " + e.getMessage());
        }

        return null;
    }
}
