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

        BufferedReader br;

        if (esUrl) {
            URL url = new URL(rutaOUrl);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
        } else {
            File archivo = new File(rutaOUrl);
            br = new BufferedReader(new FileReader(archivo));
        }

        br.readLine();

        String linea;
        while ((linea = br.readLine()) != null) {
            String[] p = linea.split(",");

            tiempo.add(Double.parseDouble(p[0].trim()));
            normal.add(Double.parseDouble(p[1].trim()));
            taquicardia.add(Double.parseDouble(p[2].trim()));
            bradicardia.add(Double.parseDouble(p[3].trim()));
        }

        br.close();
    }

    public ArrayList<Double> getTiempo() {
        return tiempo;
    }

    public ArrayList<Double> getColumna(String tipo) {
        switch (tipo) {
            case "Normal": return normal;
            case "Taquicardia": return taquicardia;
            case "Bradicardia": return bradicardia;
        }
        return null;
    }
}
