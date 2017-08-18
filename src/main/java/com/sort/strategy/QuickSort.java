package com.sort.strategy;

public class QuickSort implements Strategy {

    @Override
    public void sort(String[] a, char sortOrder) {
        quickSort(a, 0, a.length, sortOrder);
    }
    private static void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    int partition(String[] arr, int left, int right, char order) {
        int startIdx = left;
        String pivot = arr[right];
        for (int i = left; i < right; ++i) {
            if (order == 'D' ? arr[i].compareTo(pivot) >= 0 : arr[i].compareTo(pivot) <= 0) {
                swap(arr, startIdx, i);
                startIdx++;
            }
        }
        swap(arr, right, startIdx);
        return startIdx;
    }

    void quickSort(String[] arr, int left, int right, char order) {
        if (left >= right) {
            return;
        }
        if (right - left <= 16){

            insertionSort(arr, left, right, order);
        }
        else {
            int pivotIdx = partition(arr, left, right - 1, order);
            if (left < pivotIdx - 1) {
                quickSort(arr, left, pivotIdx, order);
            }
            if (pivotIdx < right) {
                quickSort(arr, pivotIdx + 1, right, order);
            }
        }
    }

    private void insertionSort(String[] arr, int left, int right, char order) {
        for(int i = left + 1; i < right; i++)
        {
            String key = arr[i];
            int j = i - 1;
            while(j >= 0 && (order == 'D' ? arr[j].compareTo(key) < 0 : arr[j].compareTo(key) > 0))
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }


}