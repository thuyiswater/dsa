package com.data;

public class QuickSort {
    public QuickSort() {}
    public int partition(MyArrayList<Customer> arr, int low, int high) {
        Customer pivot = arr.get(high);
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr.get(j).compareTo(pivot) <= 0) {
                i++;
                // swap arr[i] and arr[j]
                arr.swap(arr, i, j);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        arr.swap(arr, i + 1, high);

        return i + 1;
    }

    /* A[] --> Array to be sorted,
   l  --> Starting index,
   h  --> Ending index */
    public void qSort(MyArrayList<Customer> arr, int low, int high)
    {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
            now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            qSort(arr, low, pi - 1);
            qSort(arr, pi + 1, high);
        }
    }
}

