package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class ArchivoDatos {

    private ArrayList<Double> tiempo;
    private ArrayList<Double> normal;
    private ArrayList<Double> taquicardia;
    private ArrayList<Double> bradicardia;

    public ArchivoDatos(String rutaOUrl, boolean esUrl) throws Exception {

        tiempo = new ArrayList<>();
        normal = new ArrayList<>();
        taquicardia = new ArrayList<>();
        bradicardia = new ArrayList<>();

        try {

            BufferedReader br;

            if (esUrl) {
                URL url = new URL(rutaOUrl);
                br = new BufferedReader(new InputStreamReader(url.openStream()));
            } else {
                File archivo = new File(rutaOUrl);
                br = new BufferedReader(new FileReader(archivo));
            }

            br.readLine(); // Saltar encabezado

            String line;

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                // CSV DE 3 COLUMNAS: tiempo; valor; tipo
                String[] datos = line.split(";");

                if (datos.length < 3) {
                    System.err.println("Línea inválida: - ArchivoDatos.java:48" + line);
                    continue;
                }

                double t = Double.parseDouble(datos[0].trim());
                double val = Double.parseDouble(datos[1].trim());
                String tipo = datos[2].trim();

                tiempo.add(t);

                switch (tipo) {
                    case "Normal" -> normal.add(val);
                    case "Taquicardia" -> taquicardia.add(val);
                    case "Bradicardia" -> bradicardia.add(val);
                }
            }

            br.close();

        } catch (Exception e) {
            throw new Exception("Error cargando datos: " + e.getMessage());
        }
    }

    public ArrayList<Double> getTiempo() {
        return tiempo;
    }

    public ArrayList<Double> getColumna(String tipo) {
        return switch (tipo) {
            case "Normal" -> normal;
            case "Taquicardia" -> taquicardia;
            case "Bradicardia" -> bradicardia;
            default -> null;
        };
    }
}
