package tarea2.utils;

import java.util.Optional;

public class Node <E>{
    E data;
    Optional<Node<E>> next;

    public Node(E data) {
        this.data = data;
        next = Optional.empty();
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Optional<Node<E>> getNext() {
        return next;
    }

    public void setNext(Optional<Node<E>> next) {
        this.next = next;
    }
}
