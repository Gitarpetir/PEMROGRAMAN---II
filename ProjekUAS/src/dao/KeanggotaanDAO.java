package dao;

import model.Keanggotaan;
import model.Member;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;

public class KeanggotaanDAO {

    public void insert(Keanggotaan k) {
        String sql = "INSERT INTO keanggotaan (id_member, tanggal_mulai, tanggal_berakhir, durasi_bulan, harga_per_bulan, total_bayar) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {

            ps.setInt(1, k.getMember().getIdMember());
            ps.setDate(2, Date.valueOf(k.getTanggalMulai()));
            ps.setDate(3, Date.valueOf(k.getTanggalBerakhir()));
            ps.setInt(4, k.getDurasiBulan());
            ps.setInt(5, k.getHargaPerBulan());
            ps.setInt(6, k.getTotalBayar());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error insert keanggotaan: " + e.getMessage());
        }
    }

    public void update(Keanggotaan k) {
        String sql = "UPDATE keanggotaan SET tanggal_berakhir=?, durasi_bulan=?, total_bayar=? WHERE id_member=?";

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(k.getTanggalBerakhir()));
            ps.setInt(2, k.getDurasiBulan());
            ps.setInt(3, k.getTotalBayar());
            ps.setInt(4, k.getMember().getIdMember());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error update keanggotaan: " + e.getMessage());
        }
    }

    public Keanggotaan getByMember(Member m) {
        String sql = "SELECT * FROM keanggotaan WHERE id_member=?";

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {
        	
        	ps.setInt(1, m.getIdMember());
        	try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Keanggotaan(
                            m,
                            rs.getDate("tanggal_mulai").toLocalDate(),
                            rs.getDate("tanggal_berakhir").toLocalDate(),
                            rs.getInt("durasi_bulan"),
                            rs.getInt("harga_per_bulan"),
                            rs.getInt("total_bayar")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Error getByMember keanggotaan: " + e.getMessage());
        }

        return null;
    }


    public ArrayList<Keanggotaan> getAll() {
        String sql = "SELECT k.*, m.nama_lengkap, m.alamat, m.no_telepon FROM keanggotaan k JOIN member m ON k.id_member = m.id_member";

        ArrayList<Keanggotaan> list = new ArrayList<>();

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql);
        		ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Member m = new Member(
                        rs.getInt("id_member"),
                        rs.getString("nama_lengkap"),
                        rs.getString("alamat"),
                        rs.getString("no_telepon")
                );

                Keanggotaan k = new Keanggotaan(
                		m,
                        rs.getDate("tanggal_mulai").toLocalDate(),
                        rs.getDate("tanggal_berakhir").toLocalDate(),
                        rs.getInt("durasi_bulan"),
                        rs.getInt("harga_per_bulan"),
                        rs.getInt("total_bayar")
                );

                list.add(k);
            }

        } catch (SQLException e) {
            System.out.println("Error getAll keanggotaan: " + e.getMessage());
        }

        return list;
    }
}
