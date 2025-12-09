package model;

import javafx.beans.property.*;

public class Pelanggan {

    private IntegerProperty pelangganId = new SimpleIntegerProperty();
    private StringProperty namaPelanggan = new SimpleStringProperty();
    private StringProperty alamatPelanggan = new SimpleStringProperty();
    private StringProperty noHpPelanggan = new SimpleStringProperty();

    // Constructor select update delete
    public Pelanggan(int pelangganId, String namaPelanggan, String alamatPelanggan, String noHpPelanggan) {
        this.pelangganId.set(pelangganId);
        this.namaPelanggan.set(namaPelanggan);
        this.alamatPelanggan.set(alamatPelanggan);
        this.noHpPelanggan.set(noHpPelanggan);
    }

    // Constructor insert
    public Pelanggan(String namaPelanggan, String alamatPelanggan, String noHpPelanggan) {
        this.namaPelanggan.set(namaPelanggan);
        this.alamatPelanggan.set(alamatPelanggan);
        this.noHpPelanggan.set(noHpPelanggan);
    }

    // Getter 
    public int getPelangganId() {
        return pelangganId.get();
    }

    public String getNamaPelanggan() {
        return namaPelanggan.get();
    }

    public String getAlamatPelanggan() {
        return alamatPelanggan.get();
    }

    public String getNoHpPelanggan() {
        return noHpPelanggan.get();
    }

    // Setter 
    public void setPelangganId(int pelangganId) {
        this.pelangganId.set(pelangganId);
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan.set(namaPelanggan);
    }

    public void setAlamatPelanggan(String alamatPelanggan) {
        this.alamatPelanggan.set(alamatPelanggan);
    }

    public void setNoHpPelanggan(String noHpPelanggan) {
        this.noHpPelanggan.set(noHpPelanggan);
    }

    // Property 
    public IntegerProperty pelangganIdProperty() {
        return pelangganId;
    }

    public StringProperty namaPelangganProperty() {
        return namaPelanggan;
    }

    public StringProperty alamatPelangganProperty() {
        return alamatPelanggan;
    }

    public StringProperty noHpPelangganProperty() {
        return noHpPelanggan;
    }
}