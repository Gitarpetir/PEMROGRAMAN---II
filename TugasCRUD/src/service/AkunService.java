package service;

import dao.AkunDao;
import dao.impl.AkunImpl;
import model.Akun;

import java.util.ArrayList;

public class AkunService {

    private AkunDao akunDao = new AkunImpl();

    public void tambahAkun(String username, String password) {
        Akun akun = new Akun(username, password); 
        akunDao.insert(akun);
    }

    public void updateAkun(int idAkun, String username, String password) {
        Akun akun = new Akun(idAkun, username, password);
        akunDao.update(akun);
    }

    public void hapusAkun(int idAkun) {
        akunDao.delete(idAkun);
    }

    public ArrayList<Akun> getSemuaAkun() {
        return akunDao.getAll();
    }

    public Akun getAkunById(int idAkun) {
        return akunDao.getById(idAkun);
    }
}
