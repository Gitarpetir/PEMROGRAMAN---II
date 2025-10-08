package PRAK203_2410817110009_MUHAMMADALFIGUNAWAN;

//public class Employee { : Ini salah karena nama class tidak sama dengan nama file
public class Pegawai {
	 public String nama;
	 //public char asal; : Ini salah karena output meminta hasil String "Kingdom of Orvel" sedangkan char hanya bisa menampung 1 karakter
	 public String asal;
	 public String jabatan;
	 //public int umur; : Karena pada main tidak ada pemberian nilai untuk variabel umur, maka saya menambahkan nilai default saja sesuai output
	 public int umur = 17;
	 public String getNama() {
	 return nama;
	 }
	 public String getAsal() {
	 return asal;
	 }
	 //public void setJabatan() { : Tidak ada parameter j pada method
	 public void setJabatan(String j){
	 this.jabatan = j;
	 }
 }




