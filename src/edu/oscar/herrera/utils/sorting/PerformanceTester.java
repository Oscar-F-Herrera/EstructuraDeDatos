package edu.oscar.herrera.utils.sorting;

import java.util.Arrays;

/**
 * clase que se encarga de ver el rendimiento de los sorters
 */
public class PerformanceTester {
    public static int COMPARACIONES = 0;
    public static int MOVIMIENTOS = 0;

    /**
     * método que se encarga de calcular el rendimiento de los sorters
     * @param sorter
     */
    public static void testPerformance(Sorter sorter) {
        final int RANGO = 2_000;
        final int ITERACIONES = 500;
        final int INCREMENTOS = 100;

        double[][] performanceResults = new double[RANGO / INCREMENTOS][2];

        for (int N = 1, k = 0; N <= RANGO; N += INCREMENTOS, k++) {
            // llamar 500 veces cada algoritmo
            COMPARACIONES = 0;
            MOVIMIENTOS = 0;
            for (int i = 0; i < ITERACIONES; i++) {
                int[] array = Sorter.getRandomArray(N, Short.MIN_VALUE, Integer.MAX_VALUE);
                sorter.sort(array);

            }
            performanceResults[k][0] += sorter.getComparaciones();
            performanceResults[k][1] += sorter.getMovimientos();
            performanceResults[k][0] = performanceResults[k][0] / ((double) ITERACIONES);
            performanceResults[k][1] = performanceResults[k][1] / ((double) ITERACIONES);
        }

        for(double[] results: performanceResults)
            System.out.println(Arrays.toString(results).replace("[","").replace("]","").replace(",",""));
    }
}
