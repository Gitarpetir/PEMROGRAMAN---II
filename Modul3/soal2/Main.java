package soal2;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     LinkedList<Negara> daftarNegara = new LinkedList<>();
     
     HashMap<Integer, String> bulanMap = new HashMap<>();
     bulanMap.put(1, "Januari");
     bulanMap.put(2, "Februari");
     bulanMap.put(3, "Maret");
     bulanMap.put(4, "April");
     bulanMap.put(5, "Mei");
     bulanMap.put(6, "Juni");
     bulanMap.put(7, "Juli");
     bulanMap.put(8, "Agustus");
     bulanMap.put(9, "September");
     bulanMap.put(10, "Oktober");
     bulanMap.put(11, "November");
     bulanMap.put(12, "Desember");

     int jumlahNegara = scanner.nextInt();
     scanner.nextLine();

     for (int i = 0; i < jumlahNegara; i++) {
         String namaNegara = scanner.nextLine();
         String jenisKepemimpinan = scanner.nextLine();
         String namaPemimpin = scanner.nextLine();

         if (jenisKepemimpinan.equalsIgnoreCase("monarki")) {
             Negara negaraBaru = new Negara(namaNegara, jenisKepemimpinan, namaPemimpin);
             daftarNegara.add(negaraBaru);
         } else {
             int tanggal = scanner.nextInt();
             int bulan = scanner.nextInt();
             int tahun = scanner.nextInt();
             scanner.nextLine();
             Negara negaraBaru = new Negara(namaNegara, jenisKepemimpinan, namaPemimpin, tanggal, bulan, tahun);
             daftarNegara.add(negaraBaru);
         }
     }

     System.out.println();

     for (Negara negara : daftarNegara) {
         String gelarPemimpin;
         switch (negara.getJenisKepemimpinan().toLowerCase()) {
             case "monarki":
                 gelarPemimpin = "Raja";
                 break;
             case "presiden":
                 gelarPemimpin = "Presiden";
                 break;
             case "perdana menteri":
                 gelarPemimpin = "Perdana Menteri";
                 break;
             default:
                 gelarPemimpin = negara.getJenisKepemimpinan();
                 break;
         }

         System.out.println("Negara " + negara.getNama() + " mempunyai " + gelarPemimpin + " bernama " + negara.getNamaPemimpin());
   
         if (negara.getTahunKemerdekaan() != 0) {
             String namaBulan = bulanMap.get(negara.getBulanKemerdekaan());
             System.out.println("Deklarasi Kemerdekaan pada Tanggal " + negara.getTanggalKemerdekaan() + " " + namaBulan + " " + negara.getTahunKemerdekaan());
         }
         System.out.println();
         scanner.close();
     }

 }
}