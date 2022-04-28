package com.data;

import java.util.Arrays;

public class MyArrayList<T> {
    private Customer[] customers;
    private int size;
    // temporary capacity of array when first created
    private static final int DEFAULT_CAPACITY = 1000;

    // constructor
    public MyArrayList() {
            customers = new Customer[DEFAULT_CAPACITY];
            size = 0;
        }

        //method: add element to the last position
    public void add(T obj) {
            if (size == customers.length) {
                increaseCapa();
            }
            customers[size++] = (Customer) obj;
            size++;
        }

        // method: add element to a specific position
    public void add(int index, T obj) {
        if (size == customers.length) {
            increaseCapa();
        }
        for (int i = size - 1; i > index - 1; i--) {
            customers[i + 1] = customers[i];
        }
        customers[index] = (Customer) obj;
        size++;
    }

        // method: return element of a specific position
    public T get(int index) {
        if (index < size) {
            return (T) customers[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

        // automatically increase capacity of array when full

    private void increaseCapa() {
        int newSize = customers.length * 2;
        customers = Arrays.copyOf(customers, newSize);
    }

        // return number of element in arrays, not full capacity
    public int size() {
            return size;
        }
}

