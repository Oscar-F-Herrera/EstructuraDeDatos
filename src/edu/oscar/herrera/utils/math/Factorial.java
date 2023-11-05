package edu.oscar.herrera.utils.math;

/**
 * La clase Factorial proporciona métodos para calcular el factorial de un número de forma recursiva e iterativa
 */
public class Factorial {
    /**
     * Calcula el factorial de un número de manera recursiva
     *
     * @param n El número entero del cual se desea calcular el factorial
     * @return El factorial del número n
     */
    public static int getRecursive(int n){
        if (n == 1 || n == 0){
            return 1;
        }
        else {
            return n * getRecursive(n-1);
        }
    }

    /**
     * Calcula el factorial de un número de manera iterativa
     *
     * @param n El número entero del cual se desea calcular el factorial
     * @return El factorial del número n
     */
    public static int getIterative(int n){
        int sum = 1;

        for (int i = n; i > 0 ; i--) {
            sum *= i;
        }

        return sum;
    }
}
