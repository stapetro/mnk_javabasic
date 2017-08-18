package com.strategy;

public class BubbleSort implements Strategy {

    @Override
    public void sort(int[] numbers) {
        System.out.println("Sorting array using bubble sort strategy!");
    }
}
