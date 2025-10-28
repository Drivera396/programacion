package varios;

public class Palindromo {
    public static boolean palindromo(String palabra) {
        StringBuilder sb = new StringBuilder();
        for (char c : palabra.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        String s = sb.toString();
        String rev = new StringBuilder(s).reverse().toString();
        return s.equals(rev);
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Ingresa una palabra o frase: ");
        String input = sc.nextLine();
        System.out.println(palindromo(input));
    }
}