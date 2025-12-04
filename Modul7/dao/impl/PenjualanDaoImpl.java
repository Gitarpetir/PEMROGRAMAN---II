package dao.impl;

import dao.PenjualanDao;
import model.Penjualan;
import util.DatabaseHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PenjualanDaoImpl implements PenjualanDao {

    @Override
    public void addPenjualan(Penjualan p) throws Exception {
        // Query Insert tetap sama (Insert pakai ID)
        String sql = "INSERT INTO Penjualan (jumlah, total_harga, tanggal, pelanggan_id, buku_id) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection c = DatabaseHelper.getConnection(); 
             PreparedStatement ps = c.prepareStatement(sql)) {
            
            ps.setInt(1, p.getJumlah());
            ps.setDouble(2, p.getTotalHarga());
            ps.setDate(3, Date.valueOf(p.getTanggal()));
            ps.setInt(4, p.getPelangganId());
            ps.setInt(5, p.getBukuId());
            
            ps.executeUpdate();
        }
    }

    @Override
    public void deletePenjualan(int id) throws Exception {
        String sql = "DELETE FROM Penjualan WHERE penjualan_id=?";
        try (Connection c = DatabaseHelper.getConnection(); 
             PreparedStatement ps = c.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Penjualan> findAllPenjualan() throws Exception {
        List<Penjualan> list = new ArrayList<>();
        
        String sql = "SELECT p.penjualan_id, p.jumlah, p.total_harga, p.tanggal, " +
                     "p.pelanggan_id, p.buku_id, " +
                     "pl.nama AS nama_pelanggan, b.judul AS judul_buku " +
                     "FROM Penjualan p " +
                     "JOIN Pelanggan pl ON p.pelanggan_id = pl.pelanggan_id " +
                     "JOIN Buku b ON p.buku_id = b.buku_id " +
                     "ORDER BY p.tanggal DESC";

        try (Connection c = DatabaseHelper.getConnection(); 
             Statement s = c.createStatement(); 
             ResultSet rs = s.executeQuery(sql)) {
            
            while (rs.next()) {
                list.add(new Penjualan(
                    rs.getInt("penjualan_id"),
                    rs.getInt("jumlah"),
                    rs.getDouble("total_harga"),
                    rs.getDate("tanggal").toLocalDate(),
                    rs.getInt("pelanggan_id"),
                    rs.getInt("buku_id"),
                    rs.getString("nama_pelanggan"), 
                    rs.getString("judul_buku")
                ));
            }
        }
        return list;
    }
}