package dao.impl;

import dao.PelangganDao;
import model.Pelanggan;
import util.DatabaseHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PelangganDaoImpl implements PelangganDao {
    @Override
    public void addPelanggan(Pelanggan p) throws Exception {
        String sql = "INSERT INTO Pelanggan (nama, email, telepon) VALUES (?, ?, ?)";
        try (Connection c = DatabaseHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, p.getNama());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getTelepon());
            ps.executeUpdate();
        }
    }

    @Override
    public void editPelanggan(Pelanggan p) throws Exception {
        String sql = "UPDATE Pelanggan SET nama=?, email=?, telepon=? WHERE pelanggan_id=?";
        try (Connection c = DatabaseHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, p.getNama());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getTelepon());
            ps.setInt(4, p.getPelangganId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deletePelanggan(int id) throws Exception {
        String sql = "DELETE FROM Pelanggan WHERE pelanggan_id=?";
        try (Connection c = DatabaseHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Pelanggan> findAllPelanggan() throws Exception {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM Pelanggan";
        try (Connection c = DatabaseHelper.getConnection(); Statement s = c.createStatement(); ResultSet rs = s.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Pelanggan(rs.getInt("pelanggan_id"), rs.getString("nama"), rs.getString("email"), rs.getString("telepon")));
            }
        }
        return list;
    }
}