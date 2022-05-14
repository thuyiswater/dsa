package com.data;

public class QuickSort {
    // constructor
    public QuickSort() {}
    public int partition(MyArrayList<Customer> arr, int low, int high) {
        String pivot = arr.get(high).getID();
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            // if current element is smaller than or equal to pivot
            if (arr.get(j).getID().compareTo(pivot) <= 0) {
                i++;
                // swap arr[i] and arr[j]
                arr.swap(arr, i, j);
            }
        }

        // swap arr[i+1] and arr[high]
        arr.swap(arr, i + 1, high);

        return i + 1;
    }

    public void qSort(MyArrayList<Customer> arr, int low, int high) {
        // low is starting index, high is ending index
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);

            // recursively sort elements before partition and after partition
            qSort(arr, low, pi - 1);
            qSort(arr, pi + 1, high);
        }
    }
}

