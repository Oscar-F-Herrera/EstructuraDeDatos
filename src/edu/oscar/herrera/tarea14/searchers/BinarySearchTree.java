package edu.oscar.herrera.tarea14.searchers;

public class BinarySearchTree {

    //Atributos
    BinarySearchNode root;

    //Constructor
    public BinarySearchTree() {
        this.root = null;
    }

    //Métodos
    public boolean search(int number){
        return theRealSearch(root, number);
    }

    private boolean theRealSearch(BinarySearchNode root, int number){
        if (root == null || root.getData() == number){
            return root != null;
        }

        if (number > root.getData()){
            return theRealSearch(root.getRight(), number);
        }

        return theRealSearch(root.getLeft(), number);
    }

    public void add(int number){
        root = theRealAdd(root, number);
    }

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

    public void remove(int number){
        if (search(number)){
            theRealRemove(root, number);
        }
        else {
            System.out.println("couldnt find " + number);
        }
    }

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

    private int succesor(BinarySearchNode root){
        root = root.getRight();
        while (root.getLeft() != null){
            root = root.getLeft();
        }
        return root.getData();
    }

    private int predecesor(BinarySearchNode root){
        root = root.getLeft();
        while (root.getRight() != null){
            root = root.getRight();
        }
        return root.getData();
    }
}
