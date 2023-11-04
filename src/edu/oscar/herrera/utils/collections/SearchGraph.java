package edu.oscar.herrera.utils.collections;

import java.util.*;

/**
 * Clase que proporciona métodos para realizar búsquedas en un grafo
 */
public class SearchGraph {

    /**
     * Realiza una búsqueda en amplitud (BFS) en el grafo
     *
     * @param grafo El grafo en el que se realizará la búsqueda
     * @param inicio El nombre del vértice de inicio
     * @param objetivo El nombre del vértice objetivo
     * @return El vértice objetivo si se encuentra, o null si no se encuentra
     */
    public static Vertice breadthFirstSearch(Grafo grafo, String inicio, String objetivo) {
        Queue<Vertice> cola = new LinkedList<>();
        Set<Vertice> visitados = new HashSet<>();

        Vertice vInicio = grafo.buscarEnLista(inicio);

        cola.add(vInicio);
        visitados.add(vInicio);

        while (!cola.isEmpty()){
            Vertice vActual = cola.poll();

            if (vActual.getNombre().equals(objetivo)){
                return vActual;
            }

            List<Arista> aristasActuales = grafo.getAdyacencias(vActual);

            for (Arista arista : aristasActuales) {
                Vertice vecino = arista.getV2();
                if (!visitados.contains(vecino)){
                    cola.add(vecino);
                    visitados.add(vecino);
                }
            }
        }
        return null;
    }

    /**
     * Realiza una búsqueda en profundidad (DFS) en el grafo
     *
     * @param grafo El grafo en el que se realizará la búsqueda
     * @param inicio El nombre del vértice de inicio
     * @param objetivo El nombre del vértice objetivo
     * @return El vértice objetivo si se encuentra, o null si no se encuentra
     */
    public static Vertice deepFirstSearch(Grafo grafo, String inicio, String objetivo) {
        Stack<Vertice> stack = new Stack<>();
        Set<Vertice> visitados = new HashSet<>();

        Vertice vInicio = grafo.buscarEnLista(inicio);

        stack.add(vInicio);
        visitados.add(vInicio);

        while (!stack.isEmpty()){
            Vertice vActual = stack.pop();

            if (vActual.getNombre().equals(objetivo)){
                return vActual;
            }

            List<Arista> aristasActuales = grafo.getAdyacencias(vActual);

            for (Arista arista : aristasActuales) {
                Vertice vecino = arista.getV2();
                if (!visitados.contains(vecino)){
                    stack.add(vecino);
                    visitados.add(vecino);
                }
            }
        }
        return null;
    }
}
