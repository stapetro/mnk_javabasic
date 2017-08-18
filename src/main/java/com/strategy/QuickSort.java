package com.strategy;

public class QuickSort implements Strategy {

    @Override
    public void sort(int[] numbers) {
        System.out.println("Sorting array using quick sort strategy!");
    }
}
