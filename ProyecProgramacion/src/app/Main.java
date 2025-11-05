package app;

import modelo.BaseDatos;
import modelo.Sensor;
import vista.Pantalla;
import controlador.MonitorECG;

public class Main {
    public static void main(String[] args) {

        BaseDatos bd = new BaseDatos();
        Sensor sensor = new Sensor(bd);
        Pantalla pantalla = new Pantalla();
        MonitorECG monitor = new MonitorECG(sensor, pantalla);

        monitor.iniciar(20);
    }
}
