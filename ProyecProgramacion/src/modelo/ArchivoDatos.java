package modelo;

import java.io*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoDatos {

 private List<Double> registros;

    public ArchivoDatos(String rutaArchivo) throws Exception {
        registros = new ArrayList<>();
        cargarArchivo(rutaArchivo);
    }

    private void cargarArchivo(String ruta) throws Exception {
        File archivo = new File(ruta);

        if (!archivo.exists()) {
            throw new FileNotFoundException("El archivo de datos no existe: " + ruta);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                try {
                    registros.add(Double.parseDouble(linea));
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido ignorado: " + linea);
                }
            }
        }
    }

    @Override
    public double obtenerDato(int index) throws Exception {
        if (index < 0 || index >= registros.size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        return registros.get(index);
    }

    @Override
    public int cantidadDatos() {
        return registros.size();
    }
}

