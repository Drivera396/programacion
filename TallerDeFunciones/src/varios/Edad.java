package varios;

public class Edad {
    public static void edad() {
        String edad = JOptionPane.showInputDialog(null, "Ingresa tu edad:", "Edad", JOptionPane.QUESTION_MESSAGE);
        if (edad != null) {
            JOptionPane.showMessageDialog(null, "Tu edad es: " + edad + " años", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        edad();
    }
}
