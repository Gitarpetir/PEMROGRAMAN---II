package model;

import javafx.beans.property.*;

public class Pelanggan {
    private IntegerProperty pelangganId = new SimpleIntegerProperty();
    private StringProperty nama = new SimpleStringProperty();
    private StringProperty email = new SimpleStringProperty();
    private StringProperty telepon = new SimpleStringProperty();

    public Pelanggan(int id, String nama, String email, String telepon) {
        this.pelangganId.set(id);
        this.nama.set(nama);
        this.email.set(email);
        this.telepon.set(telepon);
    }
    
    public Pelanggan(String nama, String email, String telepon) {
        this.nama.set(nama);
        this.email.set(email);
        this.telepon.set(telepon);
    }

    public int getPelangganId() { return pelangganId.get(); }
    public IntegerProperty pelangganIdProperty() { return pelangganId; }
    
    public String getNama() { return nama.get(); }
    public void setNama(String n) { this.nama.set(n); }
    public StringProperty namaProperty() { return nama; }
    
    public String getEmail() { return email.get(); }
    public void setEmail(String e) { this.email.set(e); }
    public StringProperty emailProperty() { return email; }
    
    public String getTelepon() { return telepon.get(); }
    public void setTelepon(String t) { this.telepon.set(t); }
    public StringProperty teleponProperty() { return telepon; }
}