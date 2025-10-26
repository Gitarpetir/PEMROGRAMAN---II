package soal2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Pilih jenis hewan yang ingin diinputkan:");
		System.out.println("1 = Kucing");
		System.out.println("2 = Anjing");
		System.out.print("Masukkan pilihan: ");
		int pilihan = scan.nextInt();
		scan.nextLine();
		
		System.out.print("Nama Hewan Peliharaan: ");
		String inputNama = scan.nextLine();
		
		System.out.print("Ras: ");
		String inputRas = scan.nextLine();
		
		System.out.print("Warna Bulu: ");
		String inputBulu = scan.nextLine();
		
		if (pilihan == 1) {
		
		
			Kucing kucing1 = new Kucing (inputRas, inputNama, inputBulu);
		
			System.out.println();
			kucing1.displayDetailKucing();
		} 
		
		else if (pilihan == 2) {
			
			System.out.print("Kemampuan : ");
			String inputKemampuan = scan.nextLine().trim();
			String[] kemampuanArray = inputKemampuan.split(",");
            for (int i = 0; i < kemampuanArray.length; i++) {
                kemampuanArray[i] = kemampuanArray[i].trim();
            }
			
			Anjing anjing1 = new Anjing (inputRas, inputNama, inputBulu, kemampuanArray);
			
			System.out.println();
			anjing1.displayDetailAnjing();
		} 
		
		
		
		
		scan.close();

	}

}

