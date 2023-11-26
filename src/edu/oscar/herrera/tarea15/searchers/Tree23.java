package edu.oscar.herrera.tarea15.searchers;

import java.util.LinkedList;
import java.util.Queue;

public class Tree23 {
    private Node23 root;

    public Tree23() {
        root = null;
    }

    public void insert(int value, int index) {
        if (root == null) {
            // If the tree is empty, create a new root node.
            root = new Node23(value, index);
        } else {
            // Call the recursive insert method starting from the root.
            insert(root, value, index);
        }
    }

    private void insert(Node23 node, int value, int index) {
        // If the node is a leaf node, insert the value/index.
        if (node.getChildren().isEmpty()) {
            insertIntoNode(node, value, index);
        } else {
            // Find the child to move to.
            int childIndex = getChildIndex(node, value);

            // Recursive call to the child.
            insert(node.getChildren().get(childIndex), value, index);
        }

        // Handle splitting the node if necessary.
        if (node.getValues().size() == 3) {
            splitNode(node);
        }
    }

    private void insertIntoNode(Node23 node, int value, int index) {
        // Insert the value/index in sorted order.
        int i = 0;
        while (i < node.getValues().size() && value > node.getValues().get(i)) {
            i++;
        }

        node.getValues().add(i, value);
        node.getIndexes().add(i, index);
    }

    private void splitNode(Node23 node) {
        // Split the node into two parts.
        Node23 parent = node.getParent();

        if (parent == null) {
            // If the node is the root, create a new root.
            parent = new Node23();
            root = parent;
            node.setParent(parent);
            parent.getChildren().add(node);
        }

        // Create a new node for the right part.
        Node23 rightNode = new Node23();
        rightNode.setParent(parent);

        // Move the rightmost value/index to the new node.
        rightNode.getValues().add(node.getValues().remove(2));
        rightNode.getIndexes().add(node.getIndexes().remove(2));

        // Move the middle value/index to the parent.
        int middleValue = node.getValues().remove(1);
        int middleIndex = node.getIndexes().remove(1);
        insertIntoNode(parent, middleValue, middleIndex);

        // Adjust children if the original node had children.
        if (!node.getChildren().isEmpty()) {
            rightNode.getChildren().add(node.getChildren().remove(2));
            rightNode.getChildren().get(0).setParent(rightNode);
            rightNode.getChildren().add(node.getChildren().remove(2));
            rightNode.getChildren().get(1).setParent(rightNode);
        }

        // Link the right node to the parent.
        parent.getChildren().add(parent.getChildren().indexOf(node) + 1, rightNode);
    }

    private int getChildIndex(Node23 node, int value) {
        int i = 0;
        while (i < node.getValues().size() && value > node.getValues().get(i)) {
            i++;
        }
        return i;
    }

    public void printTree() {
        if (root == null) {
            System.out.println("Tree is empty.");
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

            System.out.println();  // Move to the next line for the next level
        }
    }
}
