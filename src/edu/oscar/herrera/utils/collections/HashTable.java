package edu.oscar.herrera.utils.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase funciona como una tabla hash que almacena valores con sus respectivas llaves
 *
 * @param <K> Tipo de la clave
 * @param <V> Tipo del valor
 */
public class HashTable <K, V>{

    //Atributos
    private int capacity = 16;
    private Entry<K, V> table[];


    //Constructor
    /**
     * Crea una tabla hash con capacidad predeterminada
     */
    public HashTable() {
        table = new Entry[capacity];
    }


    //Métodos
    /**
     * Comprueba si la tabla hash está vacía
     *
     * @return true si la tabla hash está vacía, false en caso contrario
     */
    public boolean isEmpty(){
        return this.size() == 0;
    }

    /**
     * Regresa la cantidad de entradas almacenadas en la tabla hash
     *
     * @return El tamaño de la tabla hash
     */
    public int size(){
        int size = 0;
        for (Entry<K, V> e : table) {
            while (e != null) {
                size++;
                e = e.next;
            }
        }
        return size;
    }

    /**
     * Agrega una entrada a la tabla hash. Si la llave ya existe, actualiza el valor asociado
     *
     * @param key   La llave de la entrada
     * @param value El valor asociado a la llave
     */
    public void add(K key, V value){
        int hash = key.hashCode() % capacity;
        Entry<K, V> e = table[hash];

        if (e == null){
            table[hash] = new Entry<>(key, value);
            return;
        }
        else {
            while (e.next != null){
                if (e.getKey() == key){
                    e.setValue(value);
                    return;
                }
                e = e.next;
            }
        }

        if (e.getKey() == key){
            e.setValue(value);
            return;
        }

        e.next = new Entry<>(key, value);
    }

    /**
     * Regresa el valor asociado a una llave dada en la tabla hash
     *
     * @param key La llave cuyo valor se desea obtener
     * @return El valor asociado a la clave o null si la llave no se encuentra en la tabla hash
     */
    public V get(K key){
        int hash = key.hashCode() % capacity;
        Entry<K, V> e = table[hash];

        if (e == null){
            return null;
        }
        else {
            while (e != null){
                if (e.getKey() == key){
                    return e.getValue();
                }
                e = e.next;
            }
        }

        return null;
    }

    /**
     * Regresa una lista de todos los valores almacenados en la tabla hash
     *
     * @return Una lista de los valores almacenados en la tabla hash
     */
    public List<V> getValues(){
        List<V> values = new ArrayList<>();
        for (Entry<K, V> e : table) {
            while (e != null) {
                values.add(e.getValue());
                e = e.next;
            }
        }
        return values;
    }
}

