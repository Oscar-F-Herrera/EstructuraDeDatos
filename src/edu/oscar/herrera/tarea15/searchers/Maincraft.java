package edu.oscar.herrera.tarea15.searchers;

public class Maincraft {
    public static void main(String[] args) {
        Tree23 tree = new Tree23();

        tree.insert(10,0);
        tree.insert(5,1);
        tree.insert(15,2);
        tree.insert(3,3);
        tree.insert(7,4);
        tree.insert(12,5);
        tree.insert(20,6);
        tree.insert(17,7);


        tree.printTree();
    }
}
