package controlador;

import modelo.Sensor;
import vista.Pantalla;

public class MonitorECG {

    private Sensor sensor;
    private Pantalla pantalla;

    public MonitorECG(Sensor sensor, Pantalla pantalla) {
        this.sensor = sensor;
        this.pantalla = pantalla;
    }

    public void iniciar(int muestras) {
        for (int i = 0; i < muestras; i++) {
            double lectura = sensor.leerSenal();
            pantalla.mostrarDato(lectura);

            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
