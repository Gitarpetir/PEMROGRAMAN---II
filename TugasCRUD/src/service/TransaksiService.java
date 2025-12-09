package service;

import dao.TransaksiDao;
import dao.impl.TransaksiImpl;
import model.Transaksi;

import java.time.LocalDate;
import java.util.ArrayList;

public class TransaksiService {

    private TransaksiDao transaksiDao = new TransaksiImpl();

    public void tambahTransaksi(int pelangganId, int barangId, int jumlahBarang) {

        double totalHarga = 0.0;
        LocalDate tanggalHariIni = LocalDate.now();

        Transaksi t = new Transaksi(pelangganId, barangId, jumlahBarang, totalHarga, tanggalHariIni);
        transaksiDao.insert(t);
    }

    public void updateTransaksi(int transaksiId, int pelangganId, int barangId, int jumlahBarang) {

        double totalHarga = 0.0; 
        LocalDate tanggalHariIni = LocalDate.now();

        Transaksi t = new Transaksi(transaksiId, pelangganId, barangId, jumlahBarang, totalHarga, tanggalHariIni);
        transaksiDao.update(t);
    }

    public void hapusTransaksi(int transaksiId) {
        transaksiDao.delete(transaksiId);
    }

    public ArrayList<Transaksi> getSemuaTransaksi() {
        return transaksiDao.getAll();
    }

    public Transaksi getTransaksiById(int transaksiId) {
        return transaksiDao.getById(transaksiId);
    }
}
