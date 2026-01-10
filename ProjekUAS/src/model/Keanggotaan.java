package model;

import javafx.beans.property.*;
import java.time.LocalDate;

public class Keanggotaan implements CetakKartu {

    private IntegerProperty idKeanggotaan = new SimpleIntegerProperty();
    private ObjectProperty<Member> member = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> tanggalMulai = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> tanggalBerakhir = new SimpleObjectProperty<>();
    private IntegerProperty durasiBulan = new SimpleIntegerProperty();
    private IntegerProperty hargaPerBulan = new SimpleIntegerProperty();
    private IntegerProperty totalBayar = new SimpleIntegerProperty();

    public Keanggotaan(Member member, LocalDate tanggalMulai, LocalDate tanggalBerakhir, int durasiBulan, int hargaPerBulan,int totalBayar) {
        this.member.set(member);
        this.tanggalMulai.set(tanggalMulai);
        this.tanggalBerakhir.set(tanggalBerakhir);
        this.durasiBulan.set(durasiBulan);
        this.hargaPerBulan.set(hargaPerBulan);
        this.totalBayar.set(totalBayar);
    }

    public int getIdKeanggotaan() {
    	return idKeanggotaan.get();
    	}

    public Member getMember() {
        return member.get();
        }

    public LocalDate getTanggalMulai() {
        return tanggalMulai.get();
        }

    public LocalDate getTanggalBerakhir() {
        return tanggalBerakhir.get();
        }

    public int getDurasiBulan() {
        return durasiBulan.get();
        }

    public int getHargaPerBulan() {
        return hargaPerBulan.get();
        }

    public int getTotalBayar() {
        return totalBayar.get();
        }

    public void setIdKeanggotaan(int id) {
        this.idKeanggotaan.set(id);
        }

    public void setMember(Member member) {
        this.member.set(member);
        }

    public void setTanggalMulai(LocalDate tanggalMulai) {
        this.tanggalMulai.set(tanggalMulai);  
        }

    public void setTanggalBerakhir(LocalDate tanggalBerakhir) {
        this.tanggalBerakhir.set(tanggalBerakhir);
        }

    public void setDurasiBulan(int durasiBulan) {
        this.durasiBulan.set(durasiBulan);    }

    public void setHargaPerBulan(int hargaPerBulan) {
        this.hargaPerBulan.set(hargaPerBulan);
        }

    public void setTotalBayar(int totalBayar) {
        this.totalBayar.set(totalBayar);
        }

    public IntegerProperty idKeanggotaanProperty() {
        return idKeanggotaan;
        }

    public ObjectProperty<Member> memberProperty() {
        return member;}

    public ObjectProperty<LocalDate> tanggalMulaiProperty() {
        return tanggalMulai;
        }

    public ObjectProperty<LocalDate> tanggalBerakhirProperty() {
        return tanggalBerakhir;
        }

    public IntegerProperty durasiBulanProperty() {
        return durasiBulan;
        }

    public IntegerProperty hargaPerBulanProperty() {
        return hargaPerBulan; 
        }

    public IntegerProperty totalBayarProperty() {
        return totalBayar;
        }

    @Override
    public void generateKartu() {
    }
}
