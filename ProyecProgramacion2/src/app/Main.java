package app;

import javax.imageio.ImageIO;
import javax.swing.*;
import modelo.ArchivoDatos;
import vista.Graficador;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Main {
    private static final String URL_DRIVE =
            "https://drive.google.com/uc?export=download&id=1W2I6XviLH90jphh6gyN9uEHpHN60nRP7";

    // URL de la imagen que quieres mostrar en el diálogo
    private static final String IMG_URL = "https://pbs.twimg.com/media/DXeasP3W4AEDJrs.jpg";

    public static void main(String[] args) {
        try {
            ArchivoDatos datos = new ArchivoDatos(URL_DRIVE, true);

            String[] opciones = {
                    "Ritmo sinusal normal",
                    "Taquicardia ventricular",
                    "Bradicardia sinusal"
            };

            // Creamos el panel que contendrá el texto y la imagen
            JPanel panel = new JPanel(new BorderLayout(10, 10));
            JLabel texto = new JLabel("<html><b>Seleccione el tipo de señal a graficar:</b></html>");
            panel.add(texto, BorderLayout.NORTH);

            // Intentamos cargar la imagen desde la URL
            try {
                BufferedImage img = ImageIO.read(new URL(IMG_URL));
                if (img != null) {
                    // Escalar la imagen manteniendo la proporción a un ancho máximo (ajusta si quieres otro tamaño)
                    int maxWidth = 320;
                    int width = img.getWidth();
                    int height = img.getHeight();
                    int newWidth = Math.min(maxWidth, width);
                    int newHeight = (newWidth * height) / width;
                    Image scaled = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaled);

                    JLabel imgLabel = new JLabel(icon);
                    imgLabel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
                    // Centrar la imagen en el panel
                    JPanel centro = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    centro.add(imgLabel);
                    panel.add(centro, BorderLayout.CENTER);
                }
            } catch (Exception imgEx) {
                // Si falla la carga de la imagen, la aplicación no se detiene; solo no se muestra la imagen.
                System.err.println("No se pudo cargar la imagen: " + imgEx.getMessage());
            }

            // Mostrar diálogo con el panel (mensaje) y las opciones
            int opc = JOptionPane.showOptionDialog(
                    null,
                    panel,
                    "MENÚ ECG",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,       // icon global (usamos la imagen dentro del panel en vez de aquí)
                    opciones,
                    opciones[0]
            );

            if (opc == -1) return;

            String tipo = "";
            switch (opc) {
                case 0:
                    tipo = "Normal";
                    break;
                case 1:
                    tipo = "Taquicardia";
                    break;
                case 2:
                    tipo = "Bradicardia";
                    break;
            }

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

    }
}


