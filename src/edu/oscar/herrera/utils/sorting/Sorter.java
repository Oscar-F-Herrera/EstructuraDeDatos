package edu.oscar.herrera.utils.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Esta clase es base para todos los tipos de sorters
 */
public abstract class Sorter {
    protected int COMPARACIONES = 0;
    protected int MOVIMIENTOS = 0;

    public int getComparaciones(){
        return COMPARACIONES;
    }
    public int getMovimientos(){
        return MOVIMIENTOS;
    }

    /**
     * Este método se utilizará para acomodar los arreglos
     * @param N el array
     */
    public abstract void sort(int[]N);

    /**
     * Este método nos da un arreglo aleatorio
     * @param n el array en cuestion
     * @param minVal el valor mínimo que puede tomar un dato
     * @param maxVal el valor máximo que puede tomar un dato
     * @return un arreglo aleatorio
     */
    public static int[] getRandomArray(int n, int minVal, int maxVal){
        Random random = new Random();
        return random.ints(n,minVal,maxVal).toArray();
    }

    /**
     * Este método intercambia dos datos
     * @param N arreglo
     * @param i primer dato
     * @param j segundo dato
     */
    public static void swap(int[] N, int i, int j){
        int tmp = N[i];
        N[i] = N[j];
        N[j] = tmp;
    }

    /**
     * imprime el array
     * @param N el array
     */
    private static void printArray(int[] N){
        System.out.println(Arrays.toString(N));
    }

    /**
     * determina si el array está acomodado
     * @param N el array
     * @return true si está acomodado, false si no lo está
     */
    public static boolean isSorted(int[] N){
        for (int i = 0; i < N.length-1; i++) {
            if (N[i] > N[i+1]){
                return false;
            }
        }
        return true;
    }

}
