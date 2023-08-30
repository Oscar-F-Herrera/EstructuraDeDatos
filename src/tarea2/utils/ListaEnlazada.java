package tarea2.utils;

import java.util.Optional;

public class ListaEnlazada<E> implements Lista<E> {

    Optional <Node<E>> firstNode;

    //Constructores
    public ListaEnlazada(){
        this.firstNode = Optional.empty();
    }


    @Override
    public void add(E e) {
        Optional <Node<E>> newNode = Optional.of(new Node<>(e));
        if(firstNode.isEmpty()){
            firstNode = newNode;
        }
        else{
            Optional<Node<E>> currentNode = firstNode;
            while (!currentNode.get().next.isEmpty()) {
                currentNode = currentNode.get().next;
            }
            currentNode.get().next = newNode;
        }
    }

    @Override
    public void remove(E e) {
        if(firstNode.get().data == e){
            firstNode = firstNode.get().next;
        } else {
            Optional <Node<E>> nodeRemover = firstNode.get().next;
            Optional <Node<E>> currentNode = firstNode;

            while (!nodeRemover.isEmpty()) {
                if (nodeRemover.get().data.equals(e)){
                    currentNode.get().next = nodeRemover.get().next;
                    return;
                }
                nodeRemover = nodeRemover.get().next;
                currentNode = currentNode.get().next;
            }
        }
    }

    @Override
    public Optional<E> get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        int count = 0;
        Optional <Node<E>> currentNode = firstNode;
        while (!currentNode.isEmpty()) {
            if (count == index) {
                return Optional.of(currentNode.get().data);
            }
            currentNode = currentNode.get().next;
            count++;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void update(E oldValue, E newValue) {
        Optional <Node<E>> currentNode = firstNode;

        while (!currentNode.isEmpty()) {
            if (currentNode.get().data == oldValue) {
                currentNode.get().data = newValue;
                return;
            }
            currentNode = currentNode.get().next;
        }
    }

    @Override
    public int size() {
        int size = 0;
        Optional<Node<E>> currentNode = firstNode;

        while (!currentNode.isEmpty()){
            size++;
            currentNode = currentNode.get().next;
        }
        return size;
    }

    @Override
    public boolean contains(E t) {
        Optional <Node<E>> currentNode = firstNode;
        while (!currentNode.isEmpty()) {
            if (currentNode.get().data == t){
                return true;
            }
            currentNode = currentNode.get().next;
        }
        return false;
    }

    public void showList(){
        Optional <Node<E>> currentNode = firstNode;
        while (!currentNode.isEmpty()){
            System.out.println(currentNode.get().data);
            currentNode = currentNode.get().next;
        }
    }

    public Optional<Node<E>> getFirstNode(){
        return firstNode;
    }
}
