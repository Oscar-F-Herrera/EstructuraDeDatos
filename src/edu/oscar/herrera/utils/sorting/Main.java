package edu.oscar.herrera.utils.sorting;

/**
 * clase que contiene el método main
 */
public class Main {
    /**
     * método main que llama a performance tester
     */
    public static void main(String[] args) {
        PerformanceTester.testPerformance(SorterFactory.getSorter(SorterMethods.BUBBLE));
        System.out.println();
        PerformanceTester.testPerformance(SorterFactory.getSorter(SorterMethods.SELECTION));
        System.out.println();
        PerformanceTester.testPerformance(SorterFactory.getSorter(SorterMethods.INSERTION));
        System.out.println();
        PerformanceTester.testPerformance(SorterFactory.getSorter(SorterMethods.SHELL));
        System.out.println();
        PerformanceTester.testPerformance(SorterFactory.getSorter(SorterMethods.MERGE));
        System.out.println();
    }
}
