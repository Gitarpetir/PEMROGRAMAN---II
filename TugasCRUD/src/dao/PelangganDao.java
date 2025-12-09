package dao;

import java.util.ArrayList;
import model.Pelanggan;

public interface PelangganDao {
    
	void insert(Pelanggan pelanggan);
    
	void update(Pelanggan pelanggan);
    
	void delete(int id);
    
	ArrayList<Pelanggan> getAll();
    
	Pelanggan getById(int id);
}
