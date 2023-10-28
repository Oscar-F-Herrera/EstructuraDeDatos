package edu.oscar.herrera.utils.collections;

/**
 * Esta clase sirve de base para cada entrada en la tabla hash
 *
 * @param <K> Tipo de la llave
 * @param <V> Tipo del valor
 */
public class Entry<K, V> {

    //Atributos
    private K key;
    private V value;
    protected Entry<K, V> next;

    //Constructor

    /**
     * Crea una nueva entrada con la llave y el valor proporcionados
     *
     * @param key La llave de entrada
     * @param value El valor asociado a la llave
     */
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    //Métodos

    /**
     * Regresa la llave de entrada
     *
     * @return La llave de entrada
     */
    public K getKey() {
        return key;
    }

    /**
     * Regresa el valor de esta entrada
     *
     * @return El valor de esta entrada
     */
    public V getValue() {
        return value;
    }

    /**
     * Establece el valor de esta entrada
     *
     * @param value El nuevo valor de esta entrada
     */
    public void setValue(V value) {
        this.value = value;
    }

}
