package dao;
import model.Buku;
import java.util.List;

public interface BukuDao {
    void addBuku(Buku b) throws Exception;
    void editBuku(Buku b) throws Exception;
    void deleteBuku(int id) throws Exception;
    List<Buku> findAllBuku() throws Exception;
    Buku findBukuById(int id) throws Exception;
    void reduceStok(int id, int jumlah) throws Exception; 
}