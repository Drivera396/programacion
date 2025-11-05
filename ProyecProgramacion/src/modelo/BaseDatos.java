package modelo;

import java.util.ArrayList;
import java.util.List;

public class BaseDatos {

    private List<Double> registrosECG;

    public BaseDatos() {
        registrosECG = new ArrayList<>();
        cargarDatosEjemplo();
    }

    private void cargarDatosEjemplo() {
        registrosECG.add(0.12);
        registrosECG.add(0.45);
        registrosECG.add(0.90);
        registrosECG.add(0.60);
        registrosECG.add(0.20);
        registrosECG.add(0.05);
    }

    public double obtenerDato(int index) {
        if (index < registrosECG.size()) {
            return registrosECG.get(index);
        }
        return 0.0;
    }

    public int cantidadDatos() {
        return registrosECG.size();
    }
}
