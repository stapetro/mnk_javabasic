package com.mnknowledge;

/**
 Write a program called MyPi to compute the value of π. You have to decide
 on the termination criterion used in the computation (such as the number of
 terms used or the magnitude of an additional term). Is this series suitable
 for computing π? Compare results of your Pi with java internal π and show
 in the console
 PI = 4 * (1 -1/3 + 1/5 - 1/7 + 1/9 - 1/11 + 1/13 - 1/15 ...)
 */

import java.util.Scanner;

public class MyPii {

    public static void main(String[] args) {

        getPi(getUserInput());
    }

    private static int getUserInput() {

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter number of terms: ");
        return in.nextInt();
    }

    private static void getPi(int input) {
        double sum = 0;
        long i = 0;
        for(int k = 0; k<input; k++) {
            sum += ((i % 2 == 0) ? 1 : -1) * (double) 4 / (2 * i + 1);
            i++;
        }
        System.out.println("Calculated PI is: " + sum);
        System.out.println("Math.PI value is: " + Math.PI);
        System.out.printf("Difference between Math.PI and calculated PI is: %.10f \n ", (double) (Math.PI - sum));
    }
}
