package model;

import javafx.beans.property.*;
import java.time.LocalDate;

public class Penjualan {
    private IntegerProperty penjualanId = new SimpleIntegerProperty();
    private IntegerProperty jumlah = new SimpleIntegerProperty();
    private DoubleProperty totalHarga = new SimpleDoubleProperty();
    private ObjectProperty<LocalDate> tanggal = new SimpleObjectProperty<>();
    
    private IntegerProperty pelangganId = new SimpleIntegerProperty();
    private IntegerProperty bukuId = new SimpleIntegerProperty();

    private StringProperty namaPelanggan = new SimpleStringProperty();
    private StringProperty judulBuku = new SimpleStringProperty();

    public Penjualan(int id, int jumlah, double total, LocalDate tgl, 
                     int pId, int bId, String namaPlg, String judulBk) {
        this.penjualanId.set(id);
        this.jumlah.set(jumlah);
        this.totalHarga.set(total);
        this.tanggal.set(tgl);
        this.pelangganId.set(pId);
        this.bukuId.set(bId);
        
        this.namaPelanggan.set(namaPlg);
        this.judulBuku.set(judulBk);
    }
    
    public Penjualan(int jumlah, double total, LocalDate tgl, int pId, int bId) {
        this.jumlah.set(jumlah);
        this.totalHarga.set(total);
        this.tanggal.set(tgl);
        this.pelangganId.set(pId);
        this.bukuId.set(bId);
    }
    
    public String getNamaPelanggan() { return namaPelanggan.get(); }
    public StringProperty namaPelangganProperty() { return namaPelanggan; }
    
    public String getJudulBuku() { return judulBuku.get(); }
    public StringProperty judulBukuProperty() { return judulBuku; }
    
    public int getPenjualanId() { return penjualanId.get(); }
    public IntegerProperty penjualanIdProperty() { return penjualanId; }
    public int getJumlah() { return jumlah.get(); }
    public IntegerProperty jumlahProperty() { return jumlah; }
    public double getTotalHarga() { return totalHarga.get(); }
    public DoubleProperty totalHargaProperty() { return totalHarga; }
    public LocalDate getTanggal() { return tanggal.get(); }
    public ObjectProperty<LocalDate> tanggalProperty() { return tanggal; }
    public int getPelangganId() { return pelangganId.get(); }
    public int getBukuId() { return bukuId.get(); }
}