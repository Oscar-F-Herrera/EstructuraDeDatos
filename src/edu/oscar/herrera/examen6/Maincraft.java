package edu.oscar.herrera.examen6;

import static edu.oscar.herrera.examen6.MergeArrays.mergeArrays;

public class Maincraft {
    public static void main(String[] args) {
        int[] A = new int[]{1,4,7};
        int[] B = new int[]{2,3,6,0,0,0};
        B = mergeArrays(A, B);
    }
}
