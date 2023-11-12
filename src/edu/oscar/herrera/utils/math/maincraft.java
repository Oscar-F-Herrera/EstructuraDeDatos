package edu.oscar.herrera.utils.math;

import java.util.ArrayList;

/**
 * Esta clase contiene el método main con el que probé el funcionamiento de la clase Mediana
 */
public class maincraft {
    /**
     * Método main que prueba el funcionamiento de la mediana
     */
    public static void main(String[] args) {
        ArrayList<Double> lista = new ArrayList<Double>();

        lista.add(911.0);
        lista.add(64.0);
        lista.add(32.0);
        lista.add(7.0);
        lista.add(772.0);
        lista.add(28.0);
        lista.add(24.0);
        lista.add(95.0);

        for (Double number: lista) {
            System.out.print(number + ",");
        }
        System.out.println();

        System.out.println(Mediana.getMedian(lista));
    }
}
