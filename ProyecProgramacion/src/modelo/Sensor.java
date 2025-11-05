package modelo;

public class Sensor {

    private BaseDatos baseDatos;
    private int posicionLectura;

    public Sensor(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
        this.posicionLectura = 0;
    }

    public double leerSenal() {
        double valor = baseDatos.obtenerDato(posicionLectura);
        posicionLectura++;

        if (posicionLectura >= baseDatos.cantidadDatos()) {
            posicionLectura = 0;
        }
        return valor;
    }
}
