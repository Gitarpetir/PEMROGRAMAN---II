package dao;
import model.Pelanggan;
import java.util.List;

public interface PelangganDao {
    void addPelanggan(Pelanggan p) throws Exception;
    void editPelanggan(Pelanggan p) throws Exception;
    void deletePelanggan(int id) throws Exception;
    List<Pelanggan> findAllPelanggan() throws Exception;
}