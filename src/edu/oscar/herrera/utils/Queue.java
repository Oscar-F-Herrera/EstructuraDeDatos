package edu.oscar.herrera.utils;

import java.util.Optional;

public class Queue <E> {

    private final ListaEnlazada<E> lista = new ListaEnlazada<>();

    public boolean isEmpty() {
        return (lista.size()==0);
    }

    public int size(){
        return lista.size();
    }

    public void offer(E element){
        lista.add(element);
    }

    public Optional<E> poll(){
        if (lista.size()!=0) {
            Optional<E> removedData = lista.get(0);
            lista.removeFirst();
            return removedData;
        }
        return Optional.empty();
    }

    public Optional<E> peek() {
        if (lista.size()!=0) {
            return lista.get(0);
        }
        return Optional.empty();
    }

    public void inverse(){
        Stack pila = new Stack();

        while (lista.size() != 0){
            pila.push(lista.firstNode.get().data);
            lista.removeFirst();
        }
        while (pila.size() != 0){
            Optional<E> data = pila.pop();
            lista.add(data.get());
        }
    }
}
