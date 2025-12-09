package dao.impl;

import dao.TransaksiDao;
import model.Transaksi;
import util.DatabaseUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TransaksiImpl implements TransaksiDao {

    @Override
    public void insert(Transaksi t) {
        String sql = "INSERT INTO transaksi (pelangganId, barangId, jumlahBarang, totalHarga, tanggalTransaksi) VALUES (?,?,?,?,?)";

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {

            ps.setInt(1, t.getPelangganId());
            ps.setInt(2, t.getBarangId());
            ps.setInt(3, t.getJumlahBarang());
            ps.setDouble(4, t.getTotalHarga());

            LocalDate tgl = t.getTanggalTransaksi();
            ps.setDate(5, Date.valueOf(tgl));

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error insert transaksi: " + e.getMessage());
        }
    }

    @Override
    public void update(Transaksi t) {
        String sql = "UPDATE transaksi SET pelangganId = ?, barangId = ?, jumlahBarang = ?, totalHarga = ?, tanggalTransaksi = ? WHERE transaksiId = ?";
        
        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {

            ps.setInt(1, t.getPelangganId());
            ps.setInt(2, t.getBarangId());
            ps.setInt(3, t.getJumlahBarang());
            ps.setDouble(4, t.getTotalHarga());

            LocalDate tgl = t.getTanggalTransaksi();
            ps.setDate(5, Date.valueOf(tgl));

            ps.setInt(6, t.getTransaksiId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error update transaksi: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM transaksi WHERE transaksiId = ?";

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error delete transaksi: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Transaksi> getAll() {
        String sql = "SELECT transaksiId, pelangganId, barangId, jumlahBarang, totalHarga, tanggalTransaksi FROM transaksi";

        ArrayList<Transaksi> list = new ArrayList<>();

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql);
        		ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int transaksiId = rs.getInt("transaksiId");
                int pelangganId = rs.getInt("pelangganId");
                int barangId = rs.getInt("barangId");
                int jumlahBarang = rs.getInt("jumlahBarang");
                double totalHarga = rs.getDouble("totalHarga");

                Date sqlDate = rs.getDate("tanggalTransaksi");
                LocalDate tanggal = sqlDate.toLocalDate();

                Transaksi t = new Transaksi(transaksiId, pelangganId, barangId,
                                            jumlahBarang, totalHarga, tanggal);
                list.add(t);
            }

        } catch (SQLException e) {
            System.out.println("Error getAll transaksi: " + e.getMessage());
        }

        return list;
    }

    @Override
    public Transaksi getById(int id) {
        String sql = "SELECT transaksiId, pelangganId, barangId, jumlahBarang, totalHarga, tanggalTransaksi FROM transaksi WHERE transaksiId = ?";

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {
        	
        	ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int transaksiId = rs.getInt("transaksiId");
                    int pelangganId = rs.getInt("pelangganId");
                    int barangId = rs.getInt("barangId");
                    int jumlahBarang = rs.getInt("jumlahBarang");
                    double totalHarga = rs.getDouble("totalHarga");

                    Date sqlDate = rs.getDate("tanggalTransaksi");
                    LocalDate tanggal = sqlDate.toLocalDate();

                    return new Transaksi(transaksiId, pelangganId, barangId,
                                         jumlahBarang, totalHarga, tanggal);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error getById transaksi: " + e.getMessage());
        }

        return null;
    }
}
