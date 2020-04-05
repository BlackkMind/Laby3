package zad4;

import java.util.Random;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int[] tab = new int[200];
        Random random = new Random();
        int[] wy = null;
        double k = 0;
        Scanner scanner = new Scanner(System.in);

        Sortable bombelki = new bombelki();
        Sortable wiaderka = new wiaderka();

        for(int i = 0; i < tab.length; i++) {
            tab[i] = random.nextInt(30000);
        }


        System.out.print("Wybierz sposob sortowania \n1-Babelkowe\n2-kubelkowe\nktory wybierasz?: ");
        int wyb = scanner.nextInt();

        switch (wyb) {
            case 1:
                wy = bombelki.sort(tab);
                k = bombelki.step_counting();
                break;
            case 2:
                wy = wiaderka.sort(tab);
                k = wiaderka.step_counting();
                break;
                default:
                    System.out.println("wybierac miedzy 1 a 2 nie umiesz ?\n");
                    System.exit(1);
        }


        System.out.println("Wynik: ");

        for(int i = 0; i < wy.length; i++) {
            System.out.printf("%8d", wy[i]);
            if((i + 1) % 25 == 0) {
                System.out.println();//ilosc liczb w linii
            }
        }

        System.out.println("ilosc krokow: " + k);
    }
}
