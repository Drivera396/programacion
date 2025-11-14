package algoritmo;

import modelo.Mapa;
import modelo.Posicion1;

import java.util.*;

public class Busqueda {

    private static class Node {
        Posicion1 pos;
        int g;
        int f;
        Node(Posicion1 p, int g, int f) {
            this.pos = p; this.g = g; this.f = f;
        }
    }

    public static List<Posicion1> findPath(Mapa mapa, Posicion1 inicio, Posicion1 fin) {

        PriorityQueue<Node> abiertos =
                new PriorityQueue<>(Comparator.comparingInt(n -> n.f));

        Map<Posicion1, Integer> gScore = new HashMap<>();
        Map<Posicion1, Posicion1> provieneDe = new HashMap<>();

        gScore.put(inicio, 0);
        abiertos.add(new Node(inicio, 0, heuristica(inicio, fin)));

        Set<Posicion1> cerrados = new HashSet<>();

        while (!abiertos.isEmpty()) {
            Node actual = abiertos.poll();

            if (actual.pos.equals(fin)) {
                return reconstruirRuta(provieneDe, actual.pos);
            }

            cerrados.add(actual.pos);

            for (Posicion1 vecino : vecinos(mapa, actual.pos)) {
                if (cerrados.contains(vecino)) continue;

                int tentativoG = gScore.get(actual.pos) + 1;

                if (!gScore.containsKey(vecino) || tentativoG < gScore.get(vecino)) {
                    provieneDe.put(vecino, actual.pos);
                    gScore.put(vecino, tentativoG);

                    int f = tentativoG + heuristica(vecino, fin);
                    abiertos.add(new Node(vecino, tentativoG, f));
                }
            }
        }

        return null;
    }

    private static int heuristica(Posicion1 a, Posicion1 b) {
        return a.distanciaManhattan(b);
    }

    private static List<Posicion1> reconstruirRuta(Map<Posicion1, Posicion1> provieneDe,
                                                   Posicion1 actual) {

        LinkedList<Posicion1> ruta = new LinkedList<>();
        ruta.addFirst(actual);

        while (provieneDe.containsKey(actual)) {
            actual = provieneDe.get(actual);
            ruta.addFirst(actual);
        }

        return ruta;
    }

    private static List<Posicion1> vecinos(Mapa mapa, Posicion1 p) {
        List<Posicion1> lista = new ArrayList<>();

        int f = p.getRow(), c = p.getCol();

        Posicion1 arriba = new Posicion1(f - 1, c);
        Posicion1 abajo = new Posicion1(f + 1, c);
        Posicion1 izquierda = new Posicion1(f, c - 1);
        Posicion1 derecha = new Posicion1(f, c + 1);

        if (mapa.dentroDeLimites(arriba)) lista.add(arriba);
        if (mapa.dentroDeLimites(abajo)) lista.add(abajo);
        if (mapa.dentroDeLimites(izquierda)) lista.add(izquierda);
        if (mapa.dentroDeLimites(derecha)) lista.add(derecha);

        return lista;
    }
}
