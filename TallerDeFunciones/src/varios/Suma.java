package varios;

import javax.swing.JOptionPane;

public class Suma {
    public static void suma() {
        try {
            double a = Double.parseDouble(
                JOptionPane.showInputDialog(null, "Ingresa el primer número:", "Suma", JOptionPane.QUESTION_MESSAGE)
            );
            double b = Double.parseDouble(
                JOptionPane.showInputDialog(null, "Ingresa el segundo número:", "Suma", JOptionPane.QUESTION_MESSAGE)
            );
            JOptionPane.showMessageDialog(null, "La suma es: " + (a + b), "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        suma();
    }
}