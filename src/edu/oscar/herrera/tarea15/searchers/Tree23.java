package edu.oscar.herrera.tarea15.searchers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Esta clase representa a un árbol 2-3
 *
 * @author Oscar Herrera
 */
public class Tree23 {
    private Node23 root;

    /**
     * Construye un árbol 2-3 vacío
     */
    public Tree23() {
        root = null;
    }

    /**
     * Inserta un valor con su índice asociado en el árbol 2-3
     *
     * @param value El valor a insertar
     * @param index El índice correspondiente al valor
     */
    public void insert(int value, int index) {
        if (root == null) {
            root = new Node23(value, index);
        } else {
            insert(root, value, index);
        }
    }

    //Métodos privados

    /**
     * Inserta un valor con su índice asociado en el árbol 2-3, de manera recursiva
     *
     * @param node El nodo actual en el que se está considerando la inserción
     * @param value El valor a insertar
     * @param index El índice correspondiente al valor
     */
    private void insert(Node23 node, int value, int index) {
        if (node.getChildren().isEmpty()) {
            insertIntoNode(node, value, index);
        } else {
            int childIndex = getChildIndex(node, value);
            insert(node.getChildren().get(childIndex), value, index);
        }

        if (node.getValues().size() == 3) {
            splitNode(node);
        }
    }

    /**
     * Inserta un valor con su índice asociado en un nodo hoja, manteniendo el orden
     *
     * @param node El nodo hoja en el que se va a realizar la inserción
     * @param value El valor a insertar
     * @param index El índice correspondiente al valor
     */
    private void insertIntoNode(Node23 node, int value, int index) {
        int i = 0;
        while (i < node.getValues().size() && value > node.getValues().get(i)) {
            i++;
        }

        node.getValues().add(i, value);
        node.getIndexes().add(i, index);
    }

    /**
     * Divide un nodo 2-3 en dos partes y realiza las conexiones necesarias
     *
     * @param node El nodo a dividir
     */
    private void splitNode(Node23 node) {
        Node23 parent = node.getParent();

        if (parent == null) {
            parent = new Node23();
            root = parent;
            node.setParent(parent);
            parent.getChildren().add(node);
        }

        Node23 rightNode = new Node23();
        rightNode.setParent(parent);

        rightNode.getValues().add(node.getValues().remove(2));
        rightNode.getIndexes().add(node.getIndexes().remove(2));

        int middleValue = node.getValues().remove(1);
        int middleIndex = node.getIndexes().remove(1);
        insertIntoNode(parent, middleValue, middleIndex);

        if (!node.getChildren().isEmpty()) {
            rightNode.getChildren().add(node.getChildren().remove(2));
            rightNode.getChildren().get(0).setParent(rightNode);
            rightNode.getChildren().add(node.getChildren().remove(2));
            rightNode.getChildren().get(1).setParent(rightNode);
        }

        parent.getChildren().add(parent.getChildren().indexOf(node) + 1, rightNode);
    }

    /**
     * Obtiene el índice del hijo al que se debe mover, dado un valor específico
     *
     * @param node El nodo en el que se está buscando el índice del hijo
     * @param value El valor para el cual se busca el índice del hijo
     * @return El índice del hijo al que se debe mover
     */
    private int getChildIndex(Node23 node, int value) {
        int i = 0;
        while (i < node.getValues().size() && value > node.getValues().get(i)) {
            i++;
        }
        return i;
    }

    /**
     * Imprime el contenido del árbol por niveles.
     */
    public void printTree() {
        if (root == null) {
            System.out.println("El árbol está vacío");
            return;
        }

        Queue<Node23> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node23 currentNode = queue.poll();
                System.out.print("[");
                for (int j = 0; j < currentNode.getIndexes().size(); j++) {
                    System.out.print(currentNode.getValues().get(j));
                    if (j < currentNode.getIndexes().size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.print("] ");

                if (!currentNode.getChildren().isEmpty()) {
                    queue.addAll(currentNode.getChildren());
                }
            }

            System.out.println();
        }
    }
}
