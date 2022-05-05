package com.data;

public class MergeSort {

    // Constructor
    public MergeSort() {
    }

    public MyArrayList<Customer> mergeSort(MyArrayList<Customer> list) {
        MyArrayList<Customer> left = new MyArrayList<>();
        MyArrayList<Customer> right = new MyArrayList<>();


        if (list.size() == 1) {
            return list;
        } else {
            int center = list.size() / 2;
            for (int i = 0; i < center; i++) {
                left.add(list.get(i));
            }

            for (int i = center; i < list.size(); i++) {
                right.add(list.get(i));
            }

            left  = mergeSort(left);
            right = mergeSort(right);
            merge(left, right, list);
        }
        return list;
    }

    private void merge(MyArrayList<Customer> left, MyArrayList<Customer> right, MyArrayList<Customer> list) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;


        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ((left.get(leftIndex).getID().compareTo(right.get(rightIndex).getID())) < 0) {
                list.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                list.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }

        MyArrayList<Customer> rest;
        int restIndex;

        if (leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        } else {
            rest = left;
            restIndex = leftIndex;
        }

        for (int i = restIndex; i < rest.size(); i++) {
            list.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }
}

