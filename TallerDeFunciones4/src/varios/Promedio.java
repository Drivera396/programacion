package varios;

public class Promedio {
    public static double promedio(double... nums) {
        if (nums.length == 0) throw new IllegalArgumentException("Se requieren al menos un número.");
        double suma = 0;
        for (double n : nums) suma += n;
        return suma / nums.length;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Ingresa los números que deseas promediar separados por espacios :");
        String linea = sc.nextLine().trim();
        if (linea.isEmpty()) {
            System.out.println("No ingresaste números.");
            return;
        }
        String[] parts = linea.split("\\s+");
        double[] nums = new double[parts.length];
        for (int i = 0; i < parts.length; i++) nums[i] = Double.parseDouble(parts[i]);
        System.out.println("Promedio: " + promedio(nums));
    }
}
