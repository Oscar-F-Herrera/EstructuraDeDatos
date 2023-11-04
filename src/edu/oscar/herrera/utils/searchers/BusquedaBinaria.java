package edu.oscar.herrera.utils.searchers;

import java.util.List;

public class BusquedaBinaria {
    public static int search(int[] array, int left, int right, int objective) {
        if (right >= 1){
            int mid = 1 + ((right-1)/2);
            if (array[mid] == objective){
                return mid;
            }
            if (array[mid] > objective){
                return search(array, left, mid-1, objective);
            }
            return search(array, mid+1, right, objective);
        }
        return -1;
    }
}
