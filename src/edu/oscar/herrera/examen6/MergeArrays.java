package edu.oscar.herrera.examen6;

import java.util.ArrayList;
import java.util.List;

public class MergeArrays {
    public static int[] mergeArrays(int[] A, int[] B){
        for (int i = A.length-1; i > 0; i--) {
            int indexB = B.length-1;
            while (A[i] < B[indexB] && B[indexB] != 0){
                indexB--;
            }
            B = merge(B, A[i], indexB);
        }
        return B;
    }

    private static int[] merge(int[] array, int element, int index){
        for (int i = array.length-1; i > index; i--){
            int prev = i-1;
            array[i] = array[prev];
        }
        array[index] = element;
        return array;
    }
}
