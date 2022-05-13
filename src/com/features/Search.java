package com.features;

import java.util.*;
import com.data.*;
import java.lang.Math;

public class Search {

    static Scanner input = new Scanner(System.in);  // get user input

    // ----------------------------- B I N A R Y  S E A R C H ------------------------------------
    public static int binarySearch(MyArrayList<Customer> arr, String value) {

        int left = 0;  // set index
        int right = arr.size() - 1;

        while (left <= right) {

            int mid = (left + right) / 2;  // middle value index

            if (value.compareTo(arr.get(mid).getID()) < 0) {  // go left
                right = mid - 1;  // move pointer to left
            }
            else if (value.compareTo(arr.get(mid).getID()) > 0) {  // go right
                left = mid + 1;  // move pointer to right
            }
            else {  // match value
                return mid;  // return the index of matched value
            }
        }
        return -1;  // no match result
    }

    // ------------------------------ E X A C T  S E A R C H -------------------------------------
    public static void exactSearch(MyArrayList<Customer> arr) {

        System.out.print("Please enter a complete user's ID: ");

        String value = input.nextLine();  // get input

        int index = binarySearch(arr, value);  // result from binary search

        // no user found
        if (index == -1) {
            System.out.println("\nCustomer not found");
            return;
        }

        System.out.println("\nCustomer found");
        System.out.println("ID: " + arr.get(index).getID() + " | First name: " + arr.get(index).getFirstName() + " | Last name: " +
                arr.get(index).getLastName() + " | Phone no.: " + arr.get(index).getPhone());
    }

    // ---------------------------- P A R T I A L  S E A R C H -----------------------------------
    public static int indexSearch(MyArrayList<Customer> arr, String target, String value) {

        int left = 0;  // set index
        int right = arr.size() - 1;

        while (left <= right) {

            int mid = (left + right) / 2;  // middle value index

            if (arr.get(mid).getID().contains(value)) {
                return mid;
            }
            else if (value.compareTo(arr.get(mid).getID()) < 0) {  // go left
                right = mid - 1;  // move pointer to left
            }
            else if (value.compareTo(arr.get(mid).getID()) > 0) {  // go right
                left = mid + 1;  // move pointer to right
            }
        }
        // not match result
        return -1;
    }

    public static void valueSearch(MyArrayList<Customer> arr, int index, String value) {

        int count = 10;  // max 10 customers can be found
        int startIndex = index;

        // loop to left until reach the first ID contains search letters
        for (int i = index - 1; i > 0; i--) {
            if (!arr.get(i).getID().contains(value)) {  // exit if the next value does not contain the search value
                break;
            }
            startIndex--;  // move index to left
        }

        // loop to right to get all ID contains search letters
        for (int i = startIndex; i < arr.size() - 1; i++) {
            if (!arr.get(i).getID().contains(value) || count < 1) {   // exit if the next value does not contain the search value
                break;
            }
            System.out.println("ID: " + arr.get(i).getID() + " | First name: " + arr.get(i).getFirstName() + " | Last name: " +
                    arr.get(i).getLastName() + " | Phone no.: " + arr.get(i).getPhone());
            count--;
        }
    }

    public static void partialSearch(MyArrayList<Customer> arr) {

        System.out.print("\nPlease enter customer's ID (5 -> 8 letters): ");
        String value = input.nextLine();  // get input


        // calculate number of 0 need to add
        double zero = Math.pow(10, 10 - value.length());
        String target = value + String.valueOf((int) zero).substring(1);  // convert to string and add to input

        // binarySearch to find matching value
        int index = indexSearch(arr, target, value);

        // no matching
        if (index == -1) {
            System.out.println("\nCustomer not found");
            return;
        }

        System.out.print("\nCustomer found");
        System.out.println();
        // loop forward and backward for matching value
        valueSearch(arr, index, value);
    }
}