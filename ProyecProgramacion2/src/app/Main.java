package app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Main {

    private static final String URL_DRIVE =
    "https://drive.google.com/uc?export=download&id=1hD7W6JaNF6fR8PGBIm3MJJuRCIkVfiyD";

    private static final String IMG_URL =
            "https://pbs.twimg.com/media/DXeasP3W4AEDJrs.jpg";

    public static void main(String[] args) {
        try {
            ArchivoDatos datos = new ArchivoDatos(URL_DRIVE, true);

            String[] opciones = {
                "Ritmo sinusal normal",
                "Taquicardia ventricular",
                "Bradicardia sinusal"
            };

            JPanel panel = new JPanel(new BorderLayout(10, 10));
            JLabel texto = new JLabel("<html><b>Seleccione el tipo de señal a graficar:</b></html>");
            panel.add(texto, BorderLayout.NORTH);

            try {
                BufferedImage img = ImageIO.read(new URL(IMG_URL));
                if (img != null) {
                    int maxWidth = 320;
                    int width = img.getWidth();
                    int height = img.getHeight();
                    int newWidth = Math.min(maxWidth, width);
                    int newHeight = (newWidth * height) / width;

                    Image scaled = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                    JLabel imgLabel = new JLabel(new ImageIcon(scaled));

                    JPanel centro = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    centro.add(imgLabel);
                    panel.add(centro, BorderLayout.CENTER);
                }
            } catch (Exception imgEx) {
                System.err.println("No se pudo cargar la imagen: - Main.java:48" + imgEx.getMessage());
            }

            int opc = JOptionPane.showOptionDialog(
                    null,
                    panel,
                    "MENÚ ECG",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            if (opc == -1) return;

            String tipo = switch (opc) {
                case 0 -> "Normal";
                case 1 -> "Taquicardia";
                case 2 -> "Bradicardia";
                default -> "";
            };

            Graficador.mostrarGrafica(
                    datos.getTiempo(),
                    datos.getColumna(tipo),
                    "ECG - " + tipo,
                    "Tiempo (s)",
                    "Voltaje (mV)"
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error cargando datos desde Drive:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}




