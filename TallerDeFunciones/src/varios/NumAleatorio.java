package varios;

import java.util.Random;
import java.util.Scanner;

public class NumAleatorio {
    public static void numAleatorio() {
        Random rand = new Random();
        int objetivo = rand.nextInt(100) + 1; // 1..100
        Scanner sc = new Scanner(System.in);
        System.out.println("Adivina el número entre 1 y 100.");
        while (true) {
            System.out.print("Tu intento: ");
            if (!sc.hasNextInt()) {
                sc.next(); // descarta
                System.out.println("Ingrese un número válido.");
                continue;
            }
            int intento = sc.nextInt();
            if (intento < objetivo) {
                System.out.println("El número es mayor.");
            } else if (intento > objetivo) {
                System.out.println("El número es menor.");
            } else {
                System.out.println("¡Felicitaciones, adivinaste el número!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        numAleatorio();
    }
}