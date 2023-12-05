package edu.oscar.herrera.tarea15.searchers;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa a un nodo de un árbol 2-3
 *
 * @author Oscar Herrera
 */
public class Node23 {
    private List<Integer> values;
    private List<Integer> indexes;
    private List<Node23> children;
    private Node23 parent;

    /**
     * Construye un nodo vacío
     */
    public Node23() {
        values = new ArrayList<>();
        indexes = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    /**
     * Construye un nodo con un valor y un índice especificado
     *
     * @param value El valor que contiene el nodo
     * @param index El índice correspondiente al valor
     */
    public Node23(int value, int index) {
        this();
        values.add(value);
        indexes.add(index);
    }

    /**
     * Obtiene la lista de valores almacenados en este nodo
     *
     * @return La lista de valores en este nodo
     */
    public List<Integer> getValues() {
        return values;
    }

    /**
     * Establece la lista de valores para este nodo
     *
     * @param values La nueva lista de valores para este nodo
     */
    public void setValues(List<Integer> values) {
        this.values = values;
    }

    /**
     * Obtiene la lista de índices correspondientes a los valores en este nodo
     *
     * @return La lista de índices en este nodo
     */
    public List<Integer> getIndexes() {
        return indexes;
    }

    /**
     * Establece la lista de índices para este nodo
     *
     * @param indexes La nueva lista de índices para este nodo
     */
    public void setIndexes(List<Integer> indexes) {
        this.indexes = indexes;
    }

    /**
     * Obtiene la lista de nodos hijos para este nodo
     *
     * @return La lista de nodos hijos
     */
    public List<Node23> getChildren() {
        return children;
    }

    /**
     * Establece la lista de nodos hijos para este nodo
     *
     * @param children La nueva lista de nodos hijos
     */
    public void setChildren(List<Node23> children) {
        this.children = children;
    }

    /**
     * Obtiene el nodo padre de este nodo
     *
     * @return El nodo padre
     */
    public Node23 getParent() {
        return parent;
    }

    /**
     * Establece el nodo padre para este nodo
     *
     * @param parent El nuevo nodo padre
     */
    public void setParent(Node23 parent) {
        this.parent = parent;
    }
}
