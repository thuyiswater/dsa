package com.data;

import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] elements;
    private int size;
    // temporary capacity of array when first created
    private static int DEFAULT_CAPACITY = 1000;

    // constructor
    public MyArrayList() {
            elements = new Object[DEFAULT_CAPACITY];
            size = 0;
        }

        //method: add element to the last position
    public void add(T obj) {
            if (size > elements.length) {
                increaseCapa();
            }
            elements[size] = obj;
            size++;
        }

        // method: add element to a specific position
    public void add(int index, T obj) {
        if (size == elements.length) {
            increaseCapa();
        }
        for (int i = size - 1; i > index - 1; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = obj;
        size++;
    }

        // method: return element of a specific position
    public T get(int index) {
        if (index < size) {
            return (T) elements[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

        // automatically increase capacity of array when full

    private void increaseCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

        // return number of element in arrays, not full capacity
    public int size() {
            return size;
        }
}

