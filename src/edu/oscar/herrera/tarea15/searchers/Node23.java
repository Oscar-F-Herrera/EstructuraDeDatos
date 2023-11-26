package edu.oscar.herrera.tarea15.searchers;

import java.util.ArrayList;
import java.util.List;

public class Node23 {
    private List<Integer> values;
    private List<Integer> indexes;
    private List<Node23> children;
    private Node23 parent;

    public Node23() {
        values = new ArrayList<>();
        indexes = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    public Node23(int value, int index) {
        this();
        values.add(value);
        indexes.add(index);
    }

    // Getters and setters for values, indexes, and children.

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }

    public List<Integer> getIndexes() {
        return indexes;
    }

    public void setIndexes(List<Integer> indexes) {
        this.indexes = indexes;
    }

    public List<Node23> getChildren() {
        return children;
    }

    public void setChildren(List<Node23> children) {
        this.children = children;
    }

    public Node23 getParent() {
        return parent;
    }

    public void setParent(Node23 parent) {
        this.parent = parent;
    }
}
