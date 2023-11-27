package edu.oscar.herrera.utils.math;

/**
 * La clase Fibonacci proporciona métodos para calcular números de Fibonacci de forma recursiva e iterativa
 */
public class Fibonacci {
    /**
     * Calcula el número de Fibonacci de manera recursiva
     *
     * @param n El número de Fibonacci que se desea calcular
     * @return El número de Fibonacci en la posición n
     */
    public static int getRecursive(int n){
        if (n == 0 || n == 1){
            return 1;
        }
        else {
            return getRecursive(n-1) + getRecursive(n-2);
        }
    }

    /**
     * Calcula el número de Fibonacci de manera iterativa
     *
     * @param n El número de Fibonacci que se desea calcular
     * @return El número de Fibonacci en la posición n
     */
    public static int getIterative(int n){
        int num1 = 0;
        int num2 = 1;
        int count = 0;
        int sum = 1;

        while (count < n){
            sum = num1 + num2;

            num1 = num2;
            num2 = sum;

            count++;
        }

        return sum;
    }
}
