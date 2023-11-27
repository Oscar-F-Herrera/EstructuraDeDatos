package edu.oscar.herrera.utils.searchers;

/**
 * Proporciona métodos para realizar una búsqueda binaria en un array de enteros
 */
public class BusquedaBinaria {
    /**
     * Realiza una búsqueda binaria de manera recursiva en un array ordenado.
     *
     * @param array El array ordenado en el que se realizará la búsqueda.
     * @param left El índice izquierdo del subarray en el que se realizará la búsqueda.
     * @param right El índice derecho del subarray en el que se realizará la búsqueda.
     * @param objective El valor que se busca en el array.
     * @return El índice del valor buscado en el array, o -1 si no se encuentra.
     */
    public static int recursiveSearch(int[] array, int left, int right, int objective) {
        if (right >= 1){
            int mid = left + ((right-left)/2);
            if (array[mid] == objective){
                return mid;
            }
            if (array[mid] > objective){
                return recursiveSearch(array, left, mid-1, objective);
            }
            return recursiveSearch(array, mid+1, right, objective);
        }
        return -1;
    }

    /**
     * Realiza una búsqueda binaria de manera iterativa en un array ordenado.
     *
     * @param array El array ordenado en el que se realizará la búsqueda.
     * @param objective El valor que se busca en el array.
     * @return El índice del valor buscado en el array, o -1 si no se encuentra.
     */
    public static int iterativeSearch(int[] array, int objective) {
        int left = 0;
        int right = array.length-1;

        while (left <= right){
            int mid = left + ((right-1)/2);

            if (array[mid] == objective){
                return mid;
            }
            if (array[mid] < objective){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
