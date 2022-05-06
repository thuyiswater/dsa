package com.data;

public class MyArrayList<T> {
    private Customer[] customers;
    private int size;
    // temporary capacity of array when first created
    private static final int DEFAULT_CAPACITY = 1002;

    // constructor
    public MyArrayList() {
        customers = new Customer[DEFAULT_CAPACITY];
        size = 0;
    }

    // add element to the last position
    public void add(T obj) {
        if (size == customers.length) {
            increaseCapa();
        }
        customers[size++] = (Customer) obj;
    }

    // add element to a specific position
    public void add(int index, T obj) {
        if (size == customers.length) increaseCapa();

        if (size - 1 - (index - 1) >= 0) {
            System.arraycopy(customers, index, customers, index + 1, size - 1 - (index - 1));
        }
        customers[index] = (Customer) obj;
        size++;
    }

    // return to an element of a specific position
    public Customer get(int index) {
        if (index < size) {
            return customers[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    // automatically increase capacity of array when full
    private void increaseCapa() {
        int newSize = customers.length * 2;

        Customer[] newData = new Customer[newSize];
        System.arraycopy(customers, 0, newData, 0, customers.length);
        customers = newData;
    }

    // return number of element in arrays, not full capacity
    public int size() { return size; }

    //
    public Customer set(int index, Customer newCus) {
        if (index < 0 || index >= size()) throw new ArrayIndexOutOfBoundsException();
        Customer old = customers[index];
        customers[index] = newCus;
        return old;
    }

    public void swap(MyArrayList<Customer> list, int i, int j) {
        Customer e = list.get(i);
        list.set(i, list.get(j));
        list.set(j, e);
    }
}

