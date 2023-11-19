package edu.oscar.herrera.tarea14.searchers;

/**
 * Esta clase representa a un árbol de búsqueda binaria
 *
 * @author Oscar Herrera
 */
public class BinarySearchTree {

    //Atributos
    BinarySearchNode root;

    //Constructor

    /**
     * Crea un nuevo árbol de búsqueda binaria sin raíz
     */
    public BinarySearchTree() {
        this.root = null;
    }

    //Métodos

    /**
     * Busca un número en el árbol
     *
     * @param number El número a buscar
     * @return True si el número existe o False si no existe
     */
    public boolean search(int number){
        return theRealSearch(root, number);
    }

    /**
     * Método privado que realiza la verdadera búsqueda de un número
     *
     * @param root El nodo raíz
     * @param number El número a buscar
     * @return True si el número existe o False si no existe
     */
    private boolean theRealSearch(BinarySearchNode root, int number){
        if (root == null || root.getData() == number){
            return root != null;
        }

        if (number > root.getData()){
            return theRealSearch(root.getRight(), number);
        }

        return theRealSearch(root.getLeft(), number);
    }

    /**
     * Añade un nodo al árbol
     *
     * @param number El número que contendrá el nodo
     */
    public void add(int number){
        root = theRealAdd(root, number);
    }

    /**
     * Método privado que realmente agrega un número
     *
     * @param root El nodo raíz
     * @param number El número a buscar
     * @return El nodo agrgado en la posición correspondiente
     */
    private BinarySearchNode theRealAdd(BinarySearchNode root, int number){
        if (root == null){
            root = new BinarySearchNode(number);
            return root;
        }

        if (number < root.getData()){
            root.setLeft(theRealAdd(root.getLeft(), number));
        }
        else if (number > root.getData()) {
            root.setRight(theRealAdd(root.getRight(), number));
        }

        return root;
    }

    /**
     * Elimina un nodo del árbol
     *
     * @param number El número del nodo que se va a eliminar
     */
    public void remove(int number){
        if (search(number)){
            theRealRemove(root, number);
        }
        else {
            System.out.println("couldnt find " + number);
        }
    }

    /**
     * Método privado que realmente elimina un número
     *
     * @param root El nodo raíz
     * @param number El número del nodo a eliminar
     * @return El nodo eliminado
     */
    private BinarySearchNode theRealRemove(BinarySearchNode root, int number){
        if (root == null){
            return root;
        }
        else if (number < root.getData()) {
            root.setLeft(theRealRemove(root.getLeft(), number));
        }
        else if (number > root.getData()) {
            root.setRight(theRealRemove(root.getRight(), number));
        }
        else {
            if (root.getLeft() == null && root.getRight() == null){
                root = null;
            }
            else if(root.getRight() != null){
                root.setData(succesor(root));
                root.setRight(theRealRemove(root.getRight(), root.getData()));
            }
            else {
                root.setData(predecesor(root));
                root.setLeft(theRealRemove(root.getLeft(), root.getData()));
            }
        }
        return root;
    }

    /**
     * Método privado que regresa el número del nodo que le sigue al indicado
     *
     * @param root El nodo indicado
     * @return El número sucesor
     */
    private int succesor(BinarySearchNode root){
        root = root.getRight();
        while (root.getLeft() != null){
            root = root.getLeft();
        }
        return root.getData();
    }

    /**
     * Método privado que regresa el número anterior al indicado
     *
     * @param root El nodo indicado
     * @return El número anterior
     */
    private int predecesor(BinarySearchNode root){
        root = root.getLeft();
        while (root.getRight() != null){
            root = root.getRight();
        }
        return root.getData();
    }
}
