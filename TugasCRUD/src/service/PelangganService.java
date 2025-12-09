package service;

import dao.PelangganDao;
import dao.impl.PelangganImpl;
import model.Pelanggan;

import java.util.ArrayList;

public class PelangganService {

    private PelangganDao pelangganDao = new PelangganImpl();

    public void tambahPelanggan(String nama, String alamat, String noHp) {
        Pelanggan p = new Pelanggan(nama, alamat, noHp);
        pelangganDao.insert(p);
    }

    public void updatePelanggan(int id, String nama, String alamat, String noHp) {
        Pelanggan p = new Pelanggan(id, nama, alamat, noHp); 
        pelangganDao.update(p);
    }

    public void hapusPelanggan(int id) {
        pelangganDao.delete(id);
    }

    public ArrayList<Pelanggan> getSemuaPelanggan() {
        return pelangganDao.getAll();
    }

    public Pelanggan getPelangganById(int id) {
        return pelangganDao.getById(id);
    }
}
