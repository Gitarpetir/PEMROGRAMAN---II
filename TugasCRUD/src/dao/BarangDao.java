package dao;

import java.util.ArrayList;
import model.Barang;

public interface BarangDao {
	
    void insert(Barang barang);
    
    void update(Barang barang);
    
    void delete(int id);
    
    ArrayList<Barang> getAll();
    
    Barang getById(int id);
}
