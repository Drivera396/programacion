package varios;

import java.util.Scanner;

public class ContVocales {
    public static int contVocales() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa una cadena: ");
        String texto = sc.nextLine();
        String vocales = "aeiouáéíóúAEIOUÁÉÍÓÚ";
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (vocales.indexOf(texto.charAt(i)) != -1) {
                contador++;
            }
        }
        System.out.println("Número de vocales: " + contador);
        return contador;
    }

    public static void main(String[] args) {
        contVocales();
    }
}
