package com.sort.strategy;

public class SelectionSort {

    public void selectionSortAscending(String[] arr)
    {
        for (int i = 0; i < arr.length - 1; ++i)
        {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; ++j)
            {
                // "<" changed to use of compareTo()
                if (arr[j].compareTo(arr[minIndex]) < 0)
                {
                    minIndex = j;
                }
            }
            // int changed to String
            String temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public void selectionSortDescending(String[] arr)
    {
        for (int i = 0; i < arr.length - 1; ++i)
        {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; ++j)
            {
                // "<" changed to use of compareTo()
                if (arr[j].compareTo(arr[minIndex]) > 0)
                {
                    minIndex = j;
                }
            }
            // int changed to String
            String temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

}
