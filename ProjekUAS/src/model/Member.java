package model;

import javafx.beans.property.*;

public class Member extends EntitasGym {

    private IntegerProperty idMember = new SimpleIntegerProperty();

    private StringProperty alamat = new SimpleStringProperty();
    private StringProperty telepon = new SimpleStringProperty();

    public Member(String nama, String alamat, String telepon) {
        super(0, nama);
        this.alamat.set(alamat);
        this.telepon.set(telepon);
    }

    public Member(int id, String nama, String alamat, String telepon) {
        super(id, nama);
        this.idMember.set(id);
        this.alamat.set(alamat);
        this.telepon.set(telepon);
    }

    public int getIdMember() {
        return idMember.get();
    }

    public void setIdMember(int id) {
        this.idMember.set(id);
        this.id.set(id); 
    }

    public IntegerProperty idMemberProperty() {
        return idMember;
    }

    public String getAlamat() {
        return alamat.get();
    }

    public void setAlamat(String alamat) {
        this.alamat.set(alamat);
    }

    public StringProperty alamatProperty() {
        return alamat;
    }

    public String getTelepon() {
        return telepon.get();
    }

    public void setTelepon(String telepon) {
        this.telepon.set(telepon);
    }

    public StringProperty teleponProperty() {
        return telepon;
    }

    @Override
    public String getIdentitas() {
        return "Member: " + getNama();
    }

    @Override
    public String toString() {
        return getNama();
    }
}
