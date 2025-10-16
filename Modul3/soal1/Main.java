package soal1;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    LinkedList<Dadu> kumpulanDadu = new LinkedList<>();
    System.out.print("Masukkan jumlah dadu: ");
    int jumlahDadu = scanner.nextInt();
    
    for (int i = 0; i < jumlahDadu; i++) {
    	kumpulanDadu.add(new Dadu());
    }
    
    int totalNilaiDadu = 0;
    int hitungDadu = 1;
    
    for (Dadu dadu : kumpulanDadu) {
        int nilaiDaduSaatIni = dadu.getNilai();
        System.out.println("Dadu ke-" + hitungDadu + " bernilai " + nilaiDaduSaatIni);
        
        totalNilaiDadu += nilaiDaduSaatIni;
        hitungDadu++;
        }
    
    System.out.println("Total nilai dadu keseluruhan " + totalNilaiDadu);
    scanner.close();
 }
}


