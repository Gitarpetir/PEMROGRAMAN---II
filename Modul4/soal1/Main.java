package soal1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("Nama Hewan Peliharaan: ");
		String inputNama = scan.nextLine();
		
		System.out.print("Ras: ");
		String inputRas = scan.nextLine();
		System.out.println();
		
		HewanPeliharaan hewan1 = new HewanPeliharaan(inputRas, inputNama);
		
		hewan1.display();
		
		scan.close();

	}

}
