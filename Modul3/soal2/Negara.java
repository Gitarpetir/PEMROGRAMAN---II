package soal2;

public class Negara {
 private String namaNegara;
 private String jenisKepemimpinan;
 private String namaPemimpin;
 private int tanggalKemerdekaan;
 private int bulanKemerdekaan;
 private int tahunKemerdekaan;

 
 public Negara(String namaNegara, String jenisKepemimpinan, String namaPemimpin, int tanggal, int bulan, int tahun) {
     this.namaNegara = namaNegara;
     this.jenisKepemimpinan = jenisKepemimpinan;
     this.namaPemimpin = namaPemimpin;
     this.tanggalKemerdekaan = tanggal;
     this.bulanKemerdekaan = bulan;
     this.tahunKemerdekaan = tahun;
 }

 public Negara(String namaNegara, String jenisKepemimpinan, String namaPemimpin) {
     this.namaNegara = namaNegara;
     this.jenisKepemimpinan = jenisKepemimpinan;
     this.namaPemimpin = namaPemimpin;
     this.tahunKemerdekaan = 0;
 }

 public String getNama() {
     return namaNegara;
 }

 public String getJenisKepemimpinan() {
     return jenisKepemimpinan;
 }

 public String getNamaPemimpin() {
     return namaPemimpin;
 }

 public int getTanggalKemerdekaan() {
     return tanggalKemerdekaan;
 }

 public int getBulanKemerdekaan() {
     return bulanKemerdekaan;
 }

 public int getTahunKemerdekaan() {
     return tahunKemerdekaan;
 }
}