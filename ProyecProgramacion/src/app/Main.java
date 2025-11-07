package app;

import javax.swing.JOptionPane;


import modelo.ArchivoDatos;
import modelo.Sensor;
import vista.Pantalla;
import controlador.MonitorECG;

public class Main {
    public static void main(String[] args) {

      try {

            String ruta = JOptionPane.showInputDialog(
                    null,
                    "Ingrese la ruta del archivo de datos (ej: ecg_data.txt):",
                    "Fuente de Datos",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (ruta == null || ruta.trim().isEmpty()) {
                throw new Exception("Debe ingresar una ruta válida.");
            }

            ArchivoDatos archivo = new ArchivoDatos(ruta);
            Sensor sensor = new Sensor(archivo);
            Pantalla Pantalla = new Pantalla();

            MonitorECG monitor = new MonitorECG(sensor, ventana);
            monitor.iniciar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al iniciar el sistema:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
