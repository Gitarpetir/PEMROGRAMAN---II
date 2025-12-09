package service;

import dao.BarangDao;
import dao.impl.BarangImpl;
import model.Barang;

import java.util.ArrayList;

public class BarangService {
	
	private BarangDao barangDao = new BarangImpl();
	
	public void tambahBarang(String nama, double harga, int stok) {
	    Barang b = new Barang(nama, harga, stok);
	    barangDao.insert(b);
	}
	
	public void updateBarang(int id, String nama, double harga, int stok) {
	    Barang b = new Barang(id, nama, harga, stok);
	    barangDao.update(b);
	}

	public void hapusBarang(int id) {
	    barangDao.delete(id);
	}

	public ArrayList<Barang> getSemuaBarang() {
	    return barangDao.getAll();
	}
	
	public Barang getBarangById(int id) {
	    return barangDao.getById(id);
	}

	
	
}
