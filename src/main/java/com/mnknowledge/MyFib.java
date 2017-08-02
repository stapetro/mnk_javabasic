package com.mnknowledge;

import java.util.Scanner;

/**
 Write MyFib program to display the first 30 Fibonacci numbers.
 Fibonacci formula is F(n)=F(n–1)+F(n–2) and F(1)=F(2)=1.
 Also compute their average.
 Show the result of the numbers
 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 28657 46368 75025 121393 196418 317811 514229 832040
 */
public class MyFib {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("How many numbers should be printed?");
        int input = in.nextInt();
        for(int i = 1; i<=input; i++)
        {
            System.out.print(fibonacci(i)+" ");
        }

    }
    private static int fibonacci(int num)
    {
        if(num == 1 || num == 2)
            return 1;
        return fibonacci(num-1) + fibonacci(num-2);
    }

}
