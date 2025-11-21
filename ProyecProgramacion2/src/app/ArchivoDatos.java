package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ArchivoDatos {

    private ArrayList<Double> tiempo = new ArrayList<>();
    private ArrayList<Double> normal = new ArrayList<>();
    private ArrayList<Double> taquicardia = new ArrayList<>();
    private ArrayList<Double> bradicardia = new ArrayList<>();

    public ArchivoDatos(String rutaOUrl, boolean esUrl) {

        try {
            BufferedReader br;

            if (esUrl) {
                URL url = new URL(rutaOUrl);
                br = new BufferedReader(new InputStreamReader(url.openStream()));
            } else {
                br = new BufferedReader(new FileReader(new File(rutaOUrl)));
            }

            String linea = br.readLine(); // Saltar encabezado

            while ((linea = br.readLine()) != null) {

                if (linea.trim().isEmpty())
                    continue;

                // El archivo usa PUNTO Y COMA como separador ";"
                String[] datos = linea.split(";");

                // Conversión segura
                double t = Double.parseDouble(datos[0].trim());
                double valNormal = Double.parseDouble(datos[1].trim());
                double valTaquicardia = Double.parseDouble(datos[2].trim());
                double valBradicardia = Double.parseDouble(datos[3].trim());

                // Guardar valores
                tiempo.add(t);
                normal.add(valNormal);
                taquicardia.add(valTaquicardia);
                bradicardia.add(valBradicardia);
            }

            br.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Error cargando datos:\n" + e.getMessage()
            );
        }
    }

    public ArrayList<Double> getTiempo() {
        return tiempo;
    }

    public ArrayList<Double> getNormal() {
        return normal;
    }

    public ArrayList<Double> getTaquicardia() {
        return taquicardia;
    }

    public ArrayList<Double> getBradicardia() {
        return bradicardia;
    }

    // Obtener columna según tipo
    public ArrayList<Double> getColumna(String tipo) {
        return switch (tipo) {
            case "Normal" -> normal;
            case "Taquicardia" -> taquicardia;
            case "Bradicardia" -> bradicardia;
            default -> null;
        };
    }
}

