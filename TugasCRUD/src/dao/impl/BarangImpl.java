package dao.impl;

import dao.BarangDao;
import model.Barang;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;

public class BarangImpl implements BarangDao {
	
	@Override
	public void insert (Barang barang) {
		String sql = "INSERT INTO barang (namaBarang, hargaBarang, stok) VALUES (?,?,?)";
		
		try (Connection db = DatabaseUtil.getConnection();
				PreparedStatement ps = db.prepareStatement(sql)){
			
			ps.setString(1, barang.getNamaBarang());
			ps.setDouble(2, barang.getHargaBarang());
			ps.setInt(3, barang.getStokBarang());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Error insert barang: " + e.getMessage());
		}
	}

	@Override
	public void update (Barang barang) {
		String sql = "UPDATE barang SET namaBarang = ?, hargaBarang = ?, stok = ? WHERE id = ?";
		
		try (Connection db = DatabaseUtil.getConnection();
				PreparedStatement ps = db.prepareStatement(sql)){
			
			ps.setString(1, barang.getNamaBarang());
			ps.setDouble(2, barang.getHargaBarang());
			ps.setInt(3, barang.getStokBarang());
			ps.setInt(4, barang.getBarangId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Error update barang" + e.getMessage());
		}
	}

	@Override
	public void delete (int id) {
		String sql = "DELETE FROM barang WHERE id = ?";
		
		try (Connection db = DatabaseUtil.getConnection();
				PreparedStatement ps = db.prepareStatement(sql)){
			
			ps.setInt (1, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Error delete barang" + e.getMessage());
		}
	}

	@Override
    public ArrayList<Barang> getAll() {
        String sql = "SELECT id, namaBarang, hargaBarang, stok FROM barang";
        ArrayList<Barang> list = new ArrayList<>();

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql);
        		ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("namaBarang");
                double harga = rs.getDouble("hargaBarang");
                int stok = rs.getInt("stok");

                Barang barang = new Barang(id, nama, harga, stok);
                list.add(barang);
            }

        } catch (SQLException e) {
            System.out.println("Error getAll barang: " + e.getMessage());
        }

        return list;
    }

    @Override
    public Barang getById(int id) {
        String sql = "SELECT id, namaBarang, hargaBarang, stok FROM barang WHERE id = ?";

        try (Connection db = DatabaseUtil.getConnection();
        		PreparedStatement ps = db.prepareStatement(sql)) {
        	
        	ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int barangId = rs.getInt("id");
                    String nama = rs.getString("namaBarang");
                    double harga = rs.getDouble("hargaBarang");
                    int stok = rs.getInt("stok");

                    return new Barang(barangId, nama, harga, stok);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error getById barang: " + e.getMessage());
        }

        return null;
    }
}