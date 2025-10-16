package soal3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
     int pilihan;

     do {
         System.out.println("Menu:");
         System.out.println("1. Tambah Mahasiswa");
         System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
         System.out.println("3. Cari Mahasiswa berdasarkan NIM");
         System.out.println("4. Tampilkan Daftar Mahasiswa");
         System.out.println("0. Keluar");
         System.out.print("Pilihan: ");
         pilihan = scanner.nextInt();
         scanner.nextLine();

         switch (pilihan) {
             case 1:
                 System.out.print("Masukkan Nama Mahasiswa: ");
                 String nama = scanner.nextLine();
                 System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
                 String nim = scanner.nextLine();

                 boolean nimExists = false;
                 for (Mahasiswa mhs : daftarMahasiswa) {
                     if (mhs.getNim().equals(nim)) {
                         nimExists = true;
                         break;
                     }
                 }

                 if (nimExists) {
                     System.out.println("Gagal menambahkan, NIM " + nim + " sudah terdaftar.");
                 } else {
                     Mahasiswa mahasiswaBaru = new Mahasiswa(nama, nim);
                     daftarMahasiswa.add(mahasiswaBaru);
                     System.out.println("Mahasiswa " + nama + " ditambahkan.");
                 }
                 break;

             case 2:
                 if (daftarMahasiswa.isEmpty()) {
                     System.out.println("Daftar mahasiswa masih kosong.");
                     break;
                 }
                 System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                 String nimHapus = scanner.nextLine();
                 
                 Iterator<Mahasiswa> iterator = daftarMahasiswa.iterator();
                 boolean ditemukanHapus = false;
                 while (iterator.hasNext()) {
                     Mahasiswa mhs = iterator.next();
                     if (mhs.getNim().equals(nimHapus)) {
                         iterator.remove();
                         ditemukanHapus = true;
                         break;
                     }
                 }

                 if (ditemukanHapus) {
                     System.out.println("Mahasiswa dengan NIM " + nimHapus + " dihapus.");
                 } else {
                     System.out.println("Mahasiswa dengan NIM " + nimHapus + " tidak ditemukan.");
                 }
                 break;

             case 3:
                 if (daftarMahasiswa.isEmpty()) {
                     System.out.println("Daftar mahasiswa masih kosong.");
                     break;
                 }
                 System.out.print("Masukkan NIM Mahasiswa yang akan dicari: ");
                 String nimCari = scanner.nextLine();
                 
                 boolean ditemukanCari = false;
                 for (Mahasiswa mhs : daftarMahasiswa) {
                     if (mhs.getNim().equals(nimCari)) {
                         System.out.println("Data ditemukan:");
                         System.out.println("NIM: " + mhs.getNim() + ", Nama: " + mhs.getNama());
                         ditemukanCari = true;
                         break;
                     }
                 }

                 if (!ditemukanCari) {
                     System.out.println("Mahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
                 }
                 break;

             case 4:
                 if (daftarMahasiswa.isEmpty()) {
                     System.out.println("Daftar mahasiswa masih kosong.");
                 } else {
                     System.out.println("Daftar Mahasiswa:");
                     for (Mahasiswa mhs : daftarMahasiswa) {
                         System.out.println("NIM: " + mhs.getNim() + ", Nama: " + mhs.getNama());
                     }
                 }
                 break;

             case 0:
                 System.out.println("Terima kasih");
                 break;

             default:
                 System.out.println("Pilihan tidak valid, silakan coba lagi.");
                 break;
         }

     } while (pilihan != 0);

     scanner.close();
 }
}
