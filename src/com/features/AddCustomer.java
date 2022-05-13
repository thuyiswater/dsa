package com.features;

import java.util.*;
import com.data.Customer;
import com.data.MyArrayList;

public class AddCustomer {
    static Scanner input = new Scanner(System.in);
    public static void insert(MyArrayList<Customer> arr) {
        Customer value = new Customer();
        System.out.println("\nPlease enter new customer's information: ");
        System.out.print("ID: ");
        value.setID(input.nextLine());   // get ID

        System.out.print("First name: ");
        value.setFirstName(input.nextLine());  // get First name

        System.out.print("Last name: ");
        value.setLastName(input.nextLine());  // get Last name

        System.out.print("Phone number: ");
        value.setPhone(input.nextLine());  // get Phone no.

        // call function to add user
        if (add(arr, value)) {
            System.out.println("\nSuccessfully added!");
        } else {
            System.out.println("\nCustomer already exists");
        }
    }

    public static boolean add(MyArrayList<Customer> arr, Customer value) {

        int left = 0; // 1st value in list
        int right = arr.size() - 1; // last value in list

        while (left < right) {
            int mid = (left + right) / 2;  // mid index
            if (value.getID().compareTo(arr.get(mid).getID()) > 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (right < 0) {
            arr.add(value);
        }
        // add value
        else if (value.getID().compareTo(arr.get(left).getID()) < 0) {
            arr.add(left, value);
        }
        // biggest value
        else if (value.getID().compareTo(arr.get(left).getID()) > 0) {
            arr.add(left + 1, value);
        } else return false;

        return true;
    }
}
