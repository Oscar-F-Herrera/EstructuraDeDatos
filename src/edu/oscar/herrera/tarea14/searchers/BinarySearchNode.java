package edu.oscar.herrera.tarea14.searchers;

/**
 * Esta clase representa a un nodo del árbol de búsqueda binaria
 *
 * @author Oscar Herrera
 */
public class BinarySearchNode {

    //Atributos
    private BinarySearchNode left;
    private BinarySearchNode right;
    private int data;

    //Constructor

    /**
     * Crea un nuevo nodo con un dato
     *
     * @param data El dato a almacenar en el nodo
     */
    public BinarySearchNode(int data) {
        this.data = data;
    }

    //Métodos

    /**
     * Obtiene el nodo izquierdo
     *
     * @return El nodo izquierdo
     */
    public BinarySearchNode getLeft() {
        return left;
    }

    /**
     * Establece el nodo izquierdo
     *
     * @param left El nodo a establecer
     */
    public void setLeft(BinarySearchNode left) {
        this.left = left;
    }

    /**
     * Obtiene el nodo derecho
     *
     * @return El nodo derecho
     */
    public BinarySearchNode getRight() {
        return right;
    }

    /**
     * Establece el nodo derecho
     *
     * @param right El nodo a establecer
     */
    public void setRight(BinarySearchNode right) {
        this.right = right;
    }

    /**
     * Obtiene el dato que almacena este nodo
     *
     * @return El dato que almacena este nodo
     */
    public int getData() {
        return data;
    }

    /**
     * Establece el dato que almacena este nodo
     *
     * @param data El dato que almacena este nodo
     */
    public void setData(int data) {
        this.data = data;
    }
}
