package edu.oscar.herrera.utils.math;

import edu.oscar.herrera.utils.searchers.BusquedaBinaria;

public class maincraft {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(n);
        System.out.println(Fibonacci.get(n));

        int b = 10;
        System.out.println(b);
        System.out.println(Factorial.get(b));

        int[] array = {1,3,4,5,7};
        for (int i: array) {
            System.out.print(i + ",");
        }
        System.out.println();
        System.out.println("El número 5 está en la posición: " + BusquedaBinaria.search(array,0,array.length,5));
    }
}
