package Modul1;
import java.util.Scanner;

public class PRAK104_2410817110009_MUHAMMADALFIGUNAWAN {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Tangan Abu: ");
        String tanganAbu = scan.nextLine().replace(" ", "");

        System.out.print("Tangan Bagas: ");
        String tanganBagas = scan.nextLine().replace(" ", "");
        scan.close();

        int poinAbu = 0;
        int poinBagas = 0;

        for (int i = 0; i < 3; i++) {
            char gerakanAbu = tanganAbu.charAt(i);
            char gerakanBagas = tanganBagas.charAt(i);

            if (gerakanAbu == gerakanBagas) {
                continue;
            }

            if ((gerakanAbu == 'B' && gerakanBagas == 'G') ||
                (gerakanAbu == 'G' && gerakanBagas == 'K') ||
                (gerakanAbu == 'K' && gerakanBagas == 'B')) {
                poinAbu++;
            } else {
                poinBagas++;
            }
        }

        if (poinAbu > poinBagas) {
            System.out.println("Abu");
        } else if (poinBagas > poinAbu) {
            System.out.println("Bagas");
        } else {
            System.out.println("Seri");
        }
    }
}
