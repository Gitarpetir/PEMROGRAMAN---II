package dao.impl;

import dao.PelangganDao;
import model.Pelanggan;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;

public class PelangganImpl implements PelangganDao {

    @Override
    public void insert(Pelanggan p) {
        String sql = "INSERT INTO pelanggan (namaPelanggan, alamatPelanggan, noHpPelanggan) VALUES (?,?,?)";

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {

            ps.setString(1, p.getNamaPelanggan());
            ps.setString(2, p.getAlamatPelanggan());
            ps.setString(3, p.getNoHpPelanggan());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error insert pelanggan: " + e.getMessage());
        }
    }

    @Override
    public void update(Pelanggan p) {
        String sql = "UPDATE pelanggan SET namaPelanggan = ?, alamatPelanggan = ?, noHpPelanggan = ? WHERE pelangganId = ?";

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {

            ps.setString(1, p.getNamaPelanggan());
            ps.setString(2, p.getAlamatPelanggan());
            ps.setString(3, p.getNoHpPelanggan());
            ps.setInt(4, p.getPelangganId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error update pelanggan: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM pelanggan WHERE pelangganId = ?";

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error delete pelanggan: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Pelanggan> getAll() {
        String sql = "SELECT pelangganId, namaPelanggan, alamatPelanggan, noHpPelanggan FROM pelanggan";
        ArrayList<Pelanggan> list = new ArrayList<>();

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("pelangganId");
                String nama = rs.getString("namaPelanggan");
                String alamat = rs.getString("alamatPelanggan");
                String noHp = rs.getString("noHpPelanggan");

                Pelanggan p = new Pelanggan(id, nama, alamat, noHp);
                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error getAll pelanggan: " + e.getMessage());
        }

        return list;
    }

    @Override
    public Pelanggan getById(int id) {
        String sql = "SELECT pelangganId, namaPelanggan, alamatPelanggan, noHpPelanggan FROM pelanggan WHERE pelangganId = ?";

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int pid = rs.getInt("pelangganId");
                    String nama = rs.getString("namaPelanggan");
                    String alamat = rs.getString("alamatPelanggan");
                    String noHp = rs.getString("noHpPelanggan");

                    return new Pelanggan(pid, nama, alamat, noHp);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error getById pelanggan: " + e.getMessage());
        }

        return null;
    }
}
