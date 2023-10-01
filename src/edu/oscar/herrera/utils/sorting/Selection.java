package edu.oscar.herrera.utils.sorting;

public class Selection extends Sorter{

    @Override
    public void sort(int[] N) {
        COMPARACIONES = 0;
        MOVIMIENTOS = 0;
        for (int i=0;i<N.length-1;i++){
            int minIndex = i;
            for (int j = i+1; j < N.length; j++) {
                COMPARACIONES++;
                if (N[minIndex]>N[j]){
                    minIndex = j;
                }
            }
            if (minIndex!=i){
                MOVIMIENTOS++;
                swap(N,minIndex,i);
            }
        }
    }
}
