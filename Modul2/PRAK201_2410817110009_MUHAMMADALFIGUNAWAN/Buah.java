package PRAK201_2410817110009_MUHAMMADALFIGUNAWAN;

public class Buah {

    String namaBuah;
    double beratSatuan; 
    double hargaSatuan; 
    double jumlahBeli; 

    public Buah(String nama, double berat, double harga, double beli) {
        this.namaBuah = nama;
        this.beratSatuan = berat;
        this.hargaSatuan = harga;
        this.jumlahBeli = beli;
    }
    
    public void tampilkanDetailBuah() {
        double hargaPerKg = this.hargaSatuan / this.beratSatuan;
        double hargaSebelumDiskon = hargaPerKg * this.jumlahBeli;   
        double potonganPerKelipatan = this.hargaSatuan * 0.08;
        int jumlahKelipatan = (int) (this.jumlahBeli / 4);
        double totalDiskon = potonganPerKelipatan * jumlahKelipatan;
        double hargaSetelahDiskon = hargaSebelumDiskon - totalDiskon;

        System.out.println("Nama Buah: " + this.namaBuah);
        System.out.println("Berat: " + this.beratSatuan);
        System.out.println("Harga: " + this.hargaSatuan);
        System.out.printf("Jumlah Beli: %.1fkg%n", this.jumlahBeli);
        System.out.printf("Harga Sebelum Diskon: Rp%.2f%n", hargaSebelumDiskon);
        System.out.printf("Total Diskon: Rp%.2f%n", totalDiskon);
        System.out.printf("Harga Setelah Diskon: Rp%.2f%n", hargaSetelahDiskon);
        System.out.println();
    }
}
