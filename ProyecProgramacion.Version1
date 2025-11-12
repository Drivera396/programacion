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
    public void iniciar() {
        new Thread(() -> {
            while (true) {
                try {
                    double lectura = sensor.leerSenal();
                    ventana.actualizarLectura(lectura);
                    Thread.sleep(500);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Error en la lectura: " + e.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
                  ).start();
    }
}

