package dao.impl;

import dao.BukuDao;
import model.Buku;
import util.DatabaseHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BukuDaoImpl implements BukuDao {
    @Override
    public void addBuku(Buku b) throws Exception {
        String sql = "INSERT INTO Buku (judul, penulis, harga, stok) VALUES (?, ?, ?, ?)";
        try (Connection c = DatabaseHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, b.getJudul());
            ps.setString(2, b.getPenulis());
            ps.setDouble(3, b.getHarga());
            ps.setInt(4, b.getStok());
            ps.executeUpdate();
        }
    }

    @Override
    public void editBuku(Buku b) throws Exception {
        String sql = "UPDATE Buku SET judul=?, penulis=?, harga=?, stok=? WHERE buku_id=?";
        try (Connection c = DatabaseHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, b.getJudul());
            ps.setString(2, b.getPenulis());
            ps.setDouble(3, b.getHarga());
            ps.setInt(4, b.getStok());
            ps.setInt(5, b.getBukuId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteBuku(int id) throws Exception {
        String sql = "DELETE FROM Buku WHERE buku_id=?";
        try (Connection c = DatabaseHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Buku> findAllBuku() throws Exception {
        List<Buku> list = new ArrayList<>();
        String sql = "SELECT * FROM Buku";
        try (Connection c = DatabaseHelper.getConnection(); Statement s = c.createStatement(); ResultSet rs = s.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Buku(rs.getInt("buku_id"), rs.getString("judul"), rs.getString("penulis"), rs.getDouble("harga"), rs.getInt("stok")));
            }
        }
        return list;
    }

    @Override
    public Buku findBukuById(int id) throws Exception {
        String sql = "SELECT * FROM Buku WHERE buku_id=?";
        try (Connection c = DatabaseHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Buku(rs.getInt("buku_id"), rs.getString("judul"), rs.getString("penulis"), rs.getDouble("harga"), rs.getInt("stok"));
            }
        }
        return null;
    }

    @Override
    public void reduceStok(int id, int jumlah) throws Exception {
        String sql = "UPDATE Buku SET stok = stok - ? WHERE buku_id=?";
        try (Connection c = DatabaseHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, jumlah);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }
}