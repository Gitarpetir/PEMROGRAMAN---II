package model;

import javafx.beans.property.*;
import java.time.LocalDate;

public class Transaksi {

    private IntegerProperty transaksiId = new SimpleIntegerProperty();
    private IntegerProperty pelangganId = new SimpleIntegerProperty();
    private IntegerProperty barangId = new SimpleIntegerProperty();
    private IntegerProperty jumlahBarang = new SimpleIntegerProperty();
    private DoubleProperty totalHarga = new SimpleDoubleProperty();
    private ObjectProperty<LocalDate> tanggalTransaksi = new SimpleObjectProperty<>();

    // Constructor select update delete
    public Transaksi(int transaksiId, int pelangganId, int barangId, int jumlahBarang, double totalHarga, LocalDate tanggalTransaksi) {
        this.transaksiId.set(transaksiId);
        this.pelangganId.set(pelangganId);
        this.barangId.set(barangId);
        this.jumlahBarang.set(jumlahBarang);
        this.totalHarga.set(totalHarga);
        this.tanggalTransaksi.set(tanggalTransaksi);
    }

    // Constructor insert
    public Transaksi(int pelangganId, int barangId, int jumlahBarang, double totalHarga, LocalDate tanggalTransaksi) {
        this.pelangganId.set(pelangganId);
        this.barangId.set(barangId);
        this.jumlahBarang.set(jumlahBarang);
        this.totalHarga.set(totalHarga);
        this.tanggalTransaksi.set(tanggalTransaksi);
    }

    // Getter
    public int getTransaksiId() { 
    	return transaksiId.get();
    }
    
    public int getPelangganId() { 
    	return pelangganId.get();
    }
    
    public int getBarangId() { 
    	return barangId.get(); 
    }
    
    public int getJumlahBarang() { 
    	return jumlahBarang.get(); 
    }
    
    public double getTotalHarga() { 
    	return totalHarga.get(); 
    }
    
    public LocalDate getTanggalTransaksi() { 
    	return tanggalTransaksi.get(); 
    }

    // Setter
    public void setTransaksiId(int transaksiId) { 
    	this.transaksiId.set(transaksiId); 
    }
    
    public void setPelangganId(int pelangganId) { 
    	this.pelangganId.set(pelangganId); 
    }
    
    public void setBarangId(int barangId) { 
    	this.barangId.set(barangId); 
    }
    
    public void setJumlahBarang(int jumlahBarang) { 
    	this.jumlahBarang.set(jumlahBarang); 
    }

    public void setTotalHarga(double totalHarga) { 
    	this.totalHarga.set(totalHarga); 
    }
    
    public void setTanggalTransaksi(LocalDate tanggalTransaksi) { 
    	this.tanggalTransaksi.set(tanggalTransaksi); 
    }

    // Property buat TableView
    public IntegerProperty transaksiIdProperty() { 
    	return transaksiId; 
    }
    
    public IntegerProperty pelangganIdProperty() { 
    	return pelangganId; 
    }
    
    public IntegerProperty barangIdProperty() { 
    	return barangId; 
    }
    
    public IntegerProperty jumlahBarangProperty() { 
    	return jumlahBarang; 
    }
    
    public DoubleProperty totalHargaProperty() { 
    	return totalHarga; 
    }
    
    public ObjectProperty<LocalDate> tanggalTransaksiProperty() { 
    	return tanggalTransaksi; 
    }
}