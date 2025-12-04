package service;

import dao.PelangganDao;
import dao.impl.PelangganDaoImpl;
import model.Pelanggan;
import util.ValidationUtil; 
import java.util.List;

public class PelangganService {
    private PelangganDao dao = new PelangganDaoImpl();

    public void addPelanggan(Pelanggan p) throws Exception {
        ValidationUtil.ValidasiPelanggan.validate(p);
        dao.addPelanggan(p);
    }

    public void editPelanggan(Pelanggan p) throws Exception {
        ValidationUtil.ValidasiPelanggan.validate(p);
        dao.editPelanggan(p);
    }
    
    public void deletePelanggan(int id) throws Exception { dao.deletePelanggan(id); }
    public List<Pelanggan> getAll() throws Exception { return dao.findAllPelanggan(); }
}