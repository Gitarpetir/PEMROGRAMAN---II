package dao;
import model.Penjualan;
import java.util.List;

public interface PenjualanDao {
    void addPenjualan(Penjualan p) throws Exception;
    void deletePenjualan(int id) throws Exception;
    List<Penjualan> findAllPenjualan() throws Exception;
}