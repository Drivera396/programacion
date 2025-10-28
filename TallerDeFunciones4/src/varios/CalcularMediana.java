package varios;

import java.util.Arrays;

public class CalcularMediana {
    public static double calcularMediana(double... nums) {
        if (nums.length == 0) throw new IllegalArgumentException("Se requieren al menos un número.");
        Arrays.sort(nums);
        int n = nums.length;
        if (n % 2 == 1) {
            return nums[n / 2];
        } else {
            return (nums[n/2 - 1] + nums[n/2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Ingresa los números separados por espacios para proceder a encontrar la mediana:");
        String linea = sc.nextLine().trim();
        if (linea.isEmpty()) {
            System.out.println("No ingresaste números.");
            return;
        }
        String[] parts = linea.split("\\s+");
        double[] nums = new double[parts.length];
        for (int i = 0; i < parts.length; i++) nums[i] = Double.parseDouble(parts[i]);
        System.out.println("Mediana: " + calcularMediana(nums));
    }
}
