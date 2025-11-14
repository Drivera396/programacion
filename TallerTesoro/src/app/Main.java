package app;

import modelo.Mapa;
import modelo.Posicion1;
import modelo.Explorador;
import modelo.Tesoro;
import util.Archivo;
import vista.Consola;

import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int filas = 10, columnas = 10;
        try {
            if (args.length >= 2) {
                filas = Integer.parseInt(args[0]);
                columnas = Integer.parseInt(args[1]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Argumentos inválidos — usando 10x10.");
        }

        Mapa mapa = new Mapa(filas, columnas);
        Random rnd = new Random();

        Posicion1 posExplorador = new Posicion1(rnd.nextInt(filas), rnd.nextInt(columnas));
        Posicion1 posTesoro;

        do {
            posTesoro = new Posicion1(rnd.nextInt(filas), rnd.nextInt(columnas));
        } while (posTesoro.equals(posExplorador));

        Explorador explorador = new Explorador(posExplorador);
        Tesoro tesoro = new Tesoro(posTesoro);

        Consola vista = new Consola();
        Archivo logger = null;

        try {
            logger = new Archivo("registro_movimientos.txt");
        } catch (IOException e) {
            System.out.println("No se pudo crear archivo de registro.");
        }

        vista.mostrarMapaInicial(mapa, explorador.getPosicion(), tesoro.getPosicion());
        if (logger != null) logger.log("Mapa inicial generado.");

        explorador.buscarYAvanzar(mapa, tesoro.getPosicion(), vista, logger);

        System.out.println("\nResumen:");
        System.out.println("Pasos totales: " + explorador.getPasos());

        if (logger != null) {
            logger.log("Tesoro encontrado en: " + tesoro.getPosicion());
            logger.log("Pasos totales: " + explorador.getPasos());
            logger.close();
        }
    }
}
