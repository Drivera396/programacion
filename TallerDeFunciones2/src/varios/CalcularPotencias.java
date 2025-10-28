package varios;

import javax.swing.JOptionPane;

public class CalcularPotencias {

    public static void calcularPotencias() {
        try {
            double base = Double.parseDouble(
                JOptionPane.showInputDialog(null, "Ingresa la base:", "Potencia", JOptionPane.QUESTION_MESSAGE)
            );
            double exponente = Double.parseDouble(
                JOptionPane.showInputDialog(null, "Ingresa el exponente:", "Potencia", JOptionPane.QUESTION_MESSAGE)
            );

            double resultado = Math.pow(base, exponente);
            JOptionPane.showMessageDialog(
                null,
                base + " elevado a " + exponente + " es " + resultado,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        calcularPotencias();
    }
}
