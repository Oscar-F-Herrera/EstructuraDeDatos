package edu.oscar.herrera.utils.math;

public class Factorial {
    public static int get(int n){
        if (n == 1 || n == 0){
            return 1;
        }
        else {
            return n * get(n-1);
        }
    }
}
