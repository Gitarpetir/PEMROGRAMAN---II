package model;

import javafx.beans.property.*;

public class Buku {
    private IntegerProperty bukuId = new SimpleIntegerProperty();
    private StringProperty judul = new SimpleStringProperty();
    private StringProperty penulis = new SimpleStringProperty();
    private DoubleProperty harga = new SimpleDoubleProperty();
    private IntegerProperty stok = new SimpleIntegerProperty();

    public Buku(int id, String judul, String penulis, double harga, int stok) {
        this.bukuId.set(id);
        this.judul.set(judul);
        this.penulis.set(penulis);
        this.harga.set(harga);
        this.stok.set(stok);
    }

    public Buku(String judul, String penulis, double harga, int stok) {
        this.judul.set(judul);
        this.penulis.set(penulis);
        this.harga.set(harga);
        this.stok.set(stok);
    }

    public int getBukuId() { return bukuId.get(); }
    public IntegerProperty bukuIdProperty() { return bukuId; }

    public String getJudul() { return judul.get(); }
    public void setJudul(String j) { this.judul.set(j); }
    public StringProperty judulProperty() { return judul; }

    public String getPenulis() { return penulis.get(); }
    public void setPenulis(String p) { this.penulis.set(p); }
    public StringProperty penulisProperty() { return penulis; }

    public double getHarga() { return harga.get(); }
    public void setHarga(double h) { this.harga.set(h); }
    public DoubleProperty hargaProperty() { return harga; }

    public int getStok() { return stok.get(); }
    public void setStok(int s) { this.stok.set(s); }
    public IntegerProperty stokProperty() { return stok; }
}