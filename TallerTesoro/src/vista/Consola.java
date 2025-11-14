package vista;

import modelo.Mapa;
import modelo.Posicion1;

public class Consola {

    public void mostrarMapaInicial(Mapa mapa, Posicion1 exp, Posicion1 tes) {
        System.out.println("Mapa inicial:");
        mostrarMapa(mapa, exp, tes);
        System.out.println("Explorador: " + exp + " | Tesoro: " + tes);
        System.out.println();
    }

    public void mostrarMapa(Mapa mapa, Posicion1 exp, Posicion1 tes) {

        for (int i = 0; i < mapa.getRows(); i++) {
            for (int j = 0; j < mapa.getCols(); j++) {

                Posicion1 p = new Posicion1(i, j);

                if (p.equals(exp)) System.out.print(" E ");
                else if (p.equals(tes)) System.out.print(" T ");
                else System.out.print(" - ");
            }
            System.out.println();
        }
    }

    public void mostrarPaso(Posicion1 pos, int paso) {
        System.out.println("Paso " + paso + ": " + pos);
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}
