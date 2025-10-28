package Varios;

public class AreaCilindro {
    public static double calcularArea(double radio, double altura) {
        return 2 * Math.PI * radio * altura + 2 * Math.PI * radio * radio;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Radio: ");
        double r = sc.nextDouble();
        System.out.print("Altura: ");
        double h = sc.nextDouble();
        System.out.println("Área del cilindro: " + calcularArea(r, h));
    }
}
