package vista;

import javax.swing*;
import java.awt*;
import java.util.ArrayList;

public class Graficador {
    public static void mostrarGrafica(
            ArrayList<Double> tiempo,
            ArrayList<Double> valores,
            String titulo,
            String labelX,
            String labelY
    )}

     JFrame ventana = new JFrame(titulo);
        ventana.setSize(800, 500);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ventana.add(new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(2));

                int w = getWidth();
                int h = getHeight();

                g2.drawLine(50, h - 50, w - 30, h - 50);
                g2.drawLine(50, 30, 50, h - 50);

                double maxVal = valores.stream().mapToDouble(v -> v).max().orElse(1);
                double minVal = valores.stream().mapToDouble(v -> v).min().orElse(0);

                int n = valores.size();
                double pasoX = (double)(w - 80) / n;

                for (int i = 0; i < n - 1; i++) {
                    int x1 = (int) (50 + i * pasoX);
                    int x2 = (int) (50 + (i + 1) * pasoX);

                    int y1 = (int) (h - 50 - (valores.get(i) - minVal) * (h - 80) / (maxVal - minVal));
                    int y2 = (int) (h - 50 - (valores.get(i + 1) - minVal) * (h - 80) / (maxVal - minVal));

                    g2.drawLine(x1, y1, x2, y2);
                }

                g2.drawString(labelX, w / 2, h - 10);
                g2.drawString(labelY, 10, h / 2);
            }
        });

        ventana.setVisible(true);
    }
}

