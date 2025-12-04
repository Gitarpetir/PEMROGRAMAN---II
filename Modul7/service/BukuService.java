package service;

import dao.BukuDao;
import dao.impl.BukuDaoImpl;
import model.Buku;
import util.ValidationUtil;
import java.util.List;

public class BukuService {
    private BukuDao dao = new BukuDaoImpl();

    public void addBuku(Buku b) throws Exception {
        ValidationUtil.ValidasiBuku.validate(b);
        dao.addBuku(b);
    }

    public void editBuku(Buku b) throws Exception {
        ValidationUtil.ValidasiBuku.validate(b);
        dao.editBuku(b);
    }

    public void deleteBuku(int id) throws Exception { dao.deleteBuku(id); }
    public List<Buku> getAll() throws Exception { return dao.findAllBuku(); }
}