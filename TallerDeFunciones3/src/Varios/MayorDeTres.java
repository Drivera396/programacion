package Varios;

public class MayorDeTres {
    public static double mayorDeTresNumeros(double n1, double n2, double n3) {
        return Math.max(n1, Math.max(n2, n3));
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Número 1: ");
        double a = sc.nextDouble();
        System.out.print("Número 2: ");
        double b = sc.nextDouble();
        System.out.print("Número 3: ");
        double c = sc.nextDouble();
        System.out.println("El mayor es: " + mayorDeTresNumeros(a, b, c));
    }
}
