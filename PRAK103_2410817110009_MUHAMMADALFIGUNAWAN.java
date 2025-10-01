package Modul1;
import java.util.Scanner;

public class PRAK103_2410817110009_MUHAMMADALFIGUNAWAN {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Masukkan dua angka: ");
		int n = scan.nextInt();
		int angkaAwal = scan.nextInt();
		
		int count = 0;
		int angkaSaatIni = angkaAwal;
		
		System.out.println("Hasil Deret: ");
		do {
			if (angkaSaatIni % 2 != 0) {
				System.out.print(angkaSaatIni);
				count++;
				if (count < n) {
					System.out.print(", ");
				}
			}
			angkaSaatIni++;
		}while (count < n);

		System.out.println();
		scan.close();
	}
}