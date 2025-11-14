package modelo;

import java.util.Objects;

public class Posicion1 {
    private final int fila;
    private final int col;

    public Posicion1(int fila, int col) {
        this.fila = fila;
        this.col = col;
    }

    public int getRow() { return fila; }
    public int getCol() { return col; }

    public int distanciaManhattan(Posicion1 otra) {
        return Math.abs(fila - otra.fila) + Math.abs(col - otra.col);
    }

    @Override
    public String toString() { return "(" + fila + "," + col + ")"; }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Posicion1)) return false;
        Posicion1 o = (Posicion1) obj;
        return fila == o.fila && col == o.col;
    }

    @Override
    public int hashCode() { return Objects.hash(fila, col); }
}
