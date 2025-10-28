package varios;

import java.util.Arrays;

public class MultLista {
    public static double[] multiplicarLista(double[] lista, double numero) {
        double[] res = new double[lista.length];
        for (int i = 0; i < lista.length; i++) res[i] = lista[i] * numero;
        return res;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Ingresa los números que desea sean parte de la lista separados por espacios: ");
        String linea = sc.nextLine().trim();
        if (linea.isEmpty()) {
            System.out.println("Lista vacía.");
            return;
        }
        String[] parts = linea.split("\\s+");
        double[] lista = new double[parts.length];
        for (int i = 0; i < parts.length; i++) lista[i] = Double.parseDouble(parts[i]);
        System.out.print("El número por el cual se va a multipliar la lista es: ");
        double n = sc.nextDouble();
        System.out.println(Arrays.toString(multiplicarLista(lista, n)));
    }
}
