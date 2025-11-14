package modelo;

public class Mapa {
    private final int filas;
    private final int columnas;

    public Mapa(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }

    public int getRows() { return filas; }
    public int getCols() { return columnas; }

    public boolean dentroDeLimites(Posicion1 p) {
        return p.getRow() >= 0 && p.getRow() < filas &&
               p.getCol() >= 0 && p.getCol() < columnas;
    }
}
