package service;

import dao.*;
import dao.impl.*;
import model.*;
import util.ValidationUtil; 
import java.util.List;

public class PenjualanService {
    private PenjualanDao penjualanDao = new PenjualanDaoImpl();
    private BukuDao bukuDao = new BukuDaoImpl();

    public void addTransaksi(Penjualan p) throws Exception {
        Buku buku = bukuDao.findBukuById(p.getBukuId());
        if (buku == null) {
            throw new Exception("Buku tidak ditemukan di database!");
        }

        ValidationUtil.ValidasiPenjualan.validate(p, buku.getStok());

        penjualanDao.addPenjualan(p);
        bukuDao.reduceStok(p.getBukuId(), p.getJumlah());
    }
    
    public void deleteTransaksi(int id) throws Exception { penjualanDao.deletePenjualan(id); }
    public List<Penjualan> getAll() throws Exception { return penjualanDao.findAllPenjualan(); }
}