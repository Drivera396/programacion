package varios;

import javax.swing.JOptionPane;

public class CalcularMedia {

    public static void calcularMedia() {
        String entrada = JOptionPane.showInputDialog(
            null,
            "Ingresa números separados por espacios:",
            "Media",
            JOptionPane.QUESTION_MESSAGE
        );

        if (entrada != null && !entrada.trim().isEmpty()) {
            try {
                String[] partes = entrada.trim().split("\\s+");
                double suma = 0;
                for (int i = 0; i < partes.length; i++) {
                    double valor = Double.parseDouble(partes[i]);
                    suma += valor;
                    JOptionPane.showMessageDialog(
                        null,
                        "Número " + (i + 1) + ": " + valor,
                        "Número ingresado",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
                double media = suma / partes.length;
                JOptionPane.showMessageDialog(
                    null,
                    "La media es: " + media,
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE
                );
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ingresaste números.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        calcularMedia();
    }
}
