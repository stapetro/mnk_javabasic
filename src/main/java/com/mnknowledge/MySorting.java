package com.mnknowledge;

import java.util.Arrays;

public class MySorting {


    int[] arr = {8, 5, 7, 1, 9, 3};



    public void sort() {
        int min = 0;
        for (int j = 0; j < arr.length-1; j++) {
            min = j;
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i] < arr[min]) {
                    min = i;
                }

            }


//            System.out.println(arr[min] + " position: " + min);
//            System.out.println(Arrays.toString(arr));
            swapValue(arr, j, min);

            System.out.println(Arrays.toString(arr));
        }

    }
    private void swapValue(int[] arr, int leftIndex, int rightIndex) {
        int tmp = arr[rightIndex];
        arr[rightIndex] = arr[leftIndex];
        arr[leftIndex] = tmp;
    }

}
