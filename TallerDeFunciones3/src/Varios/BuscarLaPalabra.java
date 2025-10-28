package Varios;

public class BuscarLaPalabra {
    public static boolean buscarPalabra(String cadena, String palabra) {
        return cadena.toLowerCase().contains(palabra.toLowerCase());
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Ingresa la cadena: ");
        String c = sc.nextLine();
        System.out.print("Ingresa la palabra a buscar: ");
        String p = sc.nextLine();
        System.out.println(buscarPalabra(c, p));
    }
}
