package com.mnknowledge;

/**
 * Write a program called MyPi to compute the value of π. You have to decide
 on the termination criterion used in the computation (such as the number of
 terms used or the magnitude of an additional term). Is this series suitable
 for computing π? Compare results of your Pi with java internal π and show
 in the console
 PI = 4 * (1 -1/3 + 1/5 - 1/7 + 1/9 - 1/11 + 1/13 - 1/15 ...)
 */

public class MyPi {

    public static void main(String[] args) {

        double precision = 0.0000001;
        MyPi aPi = new MyPi();
        System.out.printf("Difference between calculated PI and Math.PI is: %.10f \n ", (double) (aPi.getPI(precision) - Math.PI));

    }

    private double getPI(double precision) {
        double sum = 0.0;
        long i = 0;
        do {
            sum += ((i % 2 == 0) ? 1 : -1) * (double) 4 / (2 * i + 1);
            ++i;
        } while ((double) Math.abs(Math.PI - sum) >= precision);
        System.out.println("Number of added values/iterations is:  " + i);
        return sum;
    }

}
