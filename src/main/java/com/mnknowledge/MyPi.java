package com.mnknowledge;

/**
 * Calculating PI with a given precision.
 */

public class MyPi {

    public static void main(String[] args) {

        double precision = 0.0000001;
        MyPi aPi = new MyPi();
        System.out.printf("Difference between calculated PI and Math.PI is: %.10f \n ", (double) (aPi.getPI(precision) - Math.PI));

    }

    private double getPI(double precision) {
        double sum = 0;
        long i = 0;
        do {
            sum += ((i % 2 == 0) ? 1 : -1) * (double) 4 / (2 * i + 1);
            ++i;
        } while ((double) Math.abs(Math.PI - sum) >= precision);
        System.out.println("Number of added values/iterations is:  " + i);
        return sum;
    }

}
