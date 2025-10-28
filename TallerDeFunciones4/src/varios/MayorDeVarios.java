package varios;

public class MayorDeVarios {
    public static double mayorDeVariosNumeros(double... nums) {
        if (nums.length == 0) throw new IllegalArgumentException("Se requieren al menos un número.");
        double m = nums[0];
        for (double v : nums) if (v > m) m = v;
        return m;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Ingrese los números separados por espacios:");
        String linea = sc.nextLine().trim();
        if (linea.isEmpty()) {
            System.out.println("No ingresaste números.");
            return;
        }
        String[] parts = linea.split("\\s+");
        double[] nums = new double[parts.length];
        for (int i = 0; i < parts.length; i++) nums[i] = Double.parseDouble(parts[i]);
        System.out.println("El mayor es: " + mayorDeVariosNumeros(nums));
    }
}
