package Varios;

public class InvertirCadena {
    public static String invertirCadena(String cadena) {
        return new StringBuilder(cadena).reverse().toString();
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Ingresa una cadena: ");
        String s = sc.nextLine();
        System.out.println(invertirCadena(s));
    }
}
