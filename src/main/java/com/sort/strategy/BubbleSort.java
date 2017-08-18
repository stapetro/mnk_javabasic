package com.sort.strategy;

public class BubbleSort implements Strategy {

    @Override
    public void sort(String[] arr, char sortOrder) {
        if (sortOrder == 'A') {
            sortAscending(arr);
        } else if (sortOrder == 'D') {
            sortDescending(arr);
        } else {
            System.out.println("Please enter A for ascending order or D for descending order!");
        }
    }

    public void sortAscending(String[] arr) {
        int size = arr.length;
        for (int pass = 1; pass < size; pass++) {
            for (int i = 0; i < size - pass; i++) {

                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    final String tmp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }

    public void sortDescending(String[] arr) {
        int size = arr.length;
        for (int pass = 1; pass < size; pass++) {
            for (int i = 0; i < size - pass; i++) {

                if (arr[i].compareTo(arr[i + 1]) < 0) {
                    final String tmp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }
}



