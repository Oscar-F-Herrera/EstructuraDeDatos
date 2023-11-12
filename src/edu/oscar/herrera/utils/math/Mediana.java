package edu.oscar.herrera.utils.math;

import java.util.ArrayList;

/**
 * Esta clase proporciona un método para obtener la mediana
 */
public class Mediana {
    /**
     * Calcula la mediana de una Arraylist ya sea par o impar
     *
     * @param list la lista de números tipo double
     * @return la mediana
     */
    public static double getMedian(ArrayList<Double> list) {
        list = mergeSort(list);

        int mid = list.size() / 2;

        if (list.size() % 2 == 1) {
            return list.get(mid);
        }

        int otherMid = mid - 1;

        return (list.get(mid) + list.get(otherMid)) / 2;
    }

    /**
     * Este método se encarga de dividir la lista proporcionada para ordenarla
     *
     * @param list la lista a dividir
     * @return la lista ordenada de menor a mayor
     */
    public static ArrayList<Double> mergeSort(ArrayList<Double> list){
        if (list.size() > 1) {
            int mid = list.size() / 2;

            ArrayList<Double> left = new ArrayList<>(list.subList(0, mid));
            ArrayList<Double> right = new ArrayList<>(list.subList(mid, list.size()));

            left = mergeSort(left);
            right = mergeSort(right);

            return merge(left, right);
        }

        return list;
    }

    /**
     * En este método se encarga de ordenar listas de menor a mayor
     *
     * @param left la lista de la izquierda
     * @param right la lista de la derecha
     * @return una sola lista con los valores ordenados
     */
    public static ArrayList<Double> merge(ArrayList<Double> left, ArrayList<Double> right) {
        ArrayList<Double> mergedList = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;

        while (index1 < left.size() && index2 < right.size()) {
            if (left.get(index1) < right.get(index2)) {
                mergedList.add(left.get(index1++));
            } else {
                mergedList.add(right.get(index2++));
            }
        }

        while (index1 < left.size()) {
            mergedList.add(left.get(index1++));
        }

        while (index2 < right.size()) {
            mergedList.add(right.get(index2++));
        }

        return mergedList;
    }
}
