package varios;

public class ContarOcurrencias {
    public static int contarOcurrencias(String cadena, String palabra) {
        String lowerC = cadena.toLowerCase();
        String lowerP = palabra.toLowerCase();
        int count = 0;
        int idx = 0;
        while ((idx = lowerC.indexOf(lowerP, idx)) != -1) {
            count++;
            idx += lowerP.length(); // evita bucles infinitos (no cuenta solapadas)
        }
        return count;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Ingresa la cadena: ");
        String c = sc.nextLine();
        System.out.print("Ingresa la palabra a contar: ");
        String p = sc.nextLine();
        System.out.println("Ocurrencias: " + contarOcurrencias(c, p));
    }
}
