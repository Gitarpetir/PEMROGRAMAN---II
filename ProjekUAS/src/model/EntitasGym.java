package model;

import javafx.beans.property.*;

public abstract class EntitasGym {

    protected IntegerProperty id = new SimpleIntegerProperty();
    protected StringProperty nama = new SimpleStringProperty();

    public EntitasGym(int id, String nama) {
        this.id.set(id);
        this.nama.set(nama);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public StringProperty namaProperty() {
        return nama;
    }
    
    public abstract String getIdentitas();
}
