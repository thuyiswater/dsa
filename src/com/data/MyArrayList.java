package com.data;

public class MyArrayList<T> {
    private Customer[] customers;
    private int size;
    // temporary capacity of array when first created
    private static int DEFAULT_CAPACITY = 100000000;

    // constructor
    public MyArrayList() {
        customers = new Customer[DEFAULT_CAPACITY];
        size = 0;
    }

    // add element to the last position
    public void add(Customer obj) {
        // check if have enough capacity
        if (size == customers.length) {
            increaseCapa();
        }
        // add element to the size position then increase the size by 1
        customers[size++] = obj;
    }

    // add element to a specific position
    public void add(int index, Customer obj) {
        // check if have enough capacity
        if (size == customers.length) increaseCapa();

        // copy the elements from the i position to the current array
        for (int i = size - 1; i > index - 1; i--) {
            customers[i + 1] = customers[i];
        }

        // add element to the index position
        customers[index] = obj;
        size++;
    }

    // return an element of a specific position
    public Customer get(int index) {
        // check if index in the range
        if (index < size) {
            return customers[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    // automatically increase capacity of array when full
    private void increaseCapa() {
        int newSize = customers.length * 2;

        // copy old elements to the new arraylist
        Customer[] newData = new Customer[newSize];
        for (int i = 0; i < customers.length - 1; i++){
            newData[i] = customers[i];
        }
        customers = newData;
    }

    // return number of element in arrays, not full capacity
    public int size() { return size; }

    // replace an element with another one
    public Customer set(int index, Customer newCus) {
        // check if index in the range
        if (index < 0 || index >= size()) throw new ArrayIndexOutOfBoundsException();
        // replace the old element with the new one
        Customer old = customers[index];
        customers[index] = newCus;
        return old;
    }

    // swap position two elements
    public void swap(MyArrayList<Customer> list, int i, int j) {
        Customer e = list.get(i);
        // replace element i with j
        list.set(i, list.get(j));
        // replace element j with i
        list.set(j, e);
    }
}

