package dao;

import java.util.ArrayList;
import model.Transaksi;

public interface TransaksiDao {
    
	void insert(Transaksi transaksi);
    
	void update(Transaksi transaksi);
    
	void delete(int id);
    
	ArrayList<Transaksi> getAll();
    
	Transaksi getById(int id);
}
