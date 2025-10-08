package PRAK202_2410817110009_MUHAMMADALFIGUNAWAN;

public class Kopi {
	String namaKopi;
	String ukuran;
	double harga;
	private String Pembeli;
	private double pajak = 0.11;
	
	public String getPembeli() {
		return Pembeli;
	}
	public void setPembeli(String pembeli) {
		Pembeli = pembeli;
	}
	public double getPajak() {
		return harga * pajak;
	}
	public void setPajak(double pajak) {
		this.pajak = pajak;
	}
	
	public void info() {
		System.out.println("Nama Kopi: " + namaKopi);
		System.out.println("Ukuran: " + ukuran);
		System.out.printf("Harga:Rp. " + harga);
		System.out.println("");
	}
}




