package dao;

import java.util.ArrayList;
import model.Akun;

public interface AkunDao {

    void insert(Akun akun);

    void update(Akun akun);

    void delete(int id);

    ArrayList<Akun> getAll();

    Akun getById(int id);
}
