package edu.oscar.herrera.utils.math;

public class Fibonacci {
    public static int get(int n){
        if (n == 0 || n == 1){
            return 1;
        }
        else {
            return get(n-1) + get(n-2);
        }
    }
}
