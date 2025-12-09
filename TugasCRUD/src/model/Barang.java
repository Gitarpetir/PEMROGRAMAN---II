package model;

import javafx.beans.property.*;

public class Barang {
	
	private IntegerProperty barangId = new SimpleIntegerProperty();
	private StringProperty namaBarang = new SimpleStringProperty();
	private DoubleProperty hargaBarang = new SimpleDoubleProperty();
	private IntegerProperty stokBarang = new SimpleIntegerProperty();
	
	//Construrtor untuk delete read select
	public Barang (int barangId, String namaBarang, Double hargaBarang, int stokBarang) {
		this.barangId.set(barangId);
		this.namaBarang.set(namaBarang);
		this.hargaBarang.set(hargaBarang);
		this.stokBarang.set(stokBarang);
	}
	
	//Construct untuk insert
	public Barang (String namaBarang, Double hargaBarang, int stokBarang) {
		this.namaBarang.set(namaBarang);
		this.hargaBarang.set(hargaBarang);
		this.stokBarang.set(stokBarang);
	}
	
	//Getter
	public int getBarangId() {
		return barangId.get();
	}
	
	public String getNamaBarang() {
		return namaBarang.get();
	}
	
	public double getHargaBarang() {
		return hargaBarang.get();
	}
	
	public int getStokBarang() {
		return stokBarang.get();
	}
	
	//Setter
	public void setNamaBarang(String namaBarang) {
		this.namaBarang.set(namaBarang);
	}
	
	public void setHargaBarang(Double hargaBarang) {
		this.hargaBarang.set(hargaBarang);
	}
	
	public void setStokBarang(int stokBarang) {
		this.stokBarang.set(stokBarang);
	}
	
	//Property table view
	public IntegerProperty barangIdProperty() {
		return barangId;
	}
	
	public StringProperty namaBarangProperty() {
		return namaBarang;
	}
	
	public DoubleProperty hargaBarangProperty() {
		return hargaBarang;
	}
	
	public IntegerProperty stokBarangProperty() {
		return stokBarang;
	}
}
