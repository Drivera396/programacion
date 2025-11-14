package modelo;

import vista.Consola;
import util.Archivo;
import java.util.List;

public class Explorador {
    private Posicion1 posicion;
    private int pasos = 0;

    public Explorador(Posicion1 inicio) {
        this.posicion = inicio;
    }

    public Posicion1 getPosicion() { return posicion; }
    public int getPasos() { return pasos; }

    public void buscarYAvanzar(Mapa mapa, Posicion1 posTesoro, Consola vista, Archivo logger) {

        List<Posicion1> ruta = algoritmo.Busqueda.findPath(mapa, posicion, posTesoro);

        if (ruta == null) {
            vista.mostrarMensaje("No existe ruta hacia el tesoro.");
            return;
        }

        vista.mostrarMensaje("Ruta encontrada. Avanzando...");

        int inicio = ruta.get(0).equals(posicion) ? 1 : 0;

        for (int i = inicio; i < ruta.size(); i++) {
            avanzarA(ruta.get(i), vista, logger);
        }

        vista.mostrarMensaje("¡Tesoro encontrado!");
    }

    private void avanzarA(Posicion1 nueva, Consola vista, Archivo logger) {
        posicion = nueva;
        pasos++;
        vista.mostrarPaso(posicion, pasos);
        if (logger != null) logger.log("Paso " + pasos + ": " + posicion);
    }
}
