package com.features;

import java.util.*;

import com.data.Customer;
import com.data.MyArrayList;

import java.lang.Math;

public class Search {
    static Scanner input = new Scanner(System.in);  // get user input

        // ----------------------------- B I N A R Y  S E A R C H ------------------------------------
    public static int binarySearch(MyArrayList<Customer> arr, String value) throws Exception {

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
    public static void exactSearch(MyArrayList<Customer> arr) throws Exception {
        System.out.print("Please enter a complete user's ID: ");
        String value = input.nextLine();  // get input

        int index = binarySearch(arr, value);  // result from binary search

        if (index == -1) {
            System.out.println("No users found");
            return;
        }

        System.out.println("User found");
        System.out.println(arr.get(index));

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

            // loop to left side
            for (int i = index - 1; i > index - 10; i--) {
                if (!arr.get(i).getID().contains(value)) {  // exit if the next value does not contain the search value
                    break;
                }
                System.out.println(arr.get(i));
            }

            // loop to right
            for (int i = index + 1; i < index + 10; i++) {
                if (!arr.get(i).getID().contains(value)) {   // exit if the next value does not contain the search value
                    break;
                }
                System.out.println(arr.get(i));
            }
        }

        public static void partialSearch(MyArrayList<Customer> arr) throws Exception {
            System.out.print("\nPlease enter customer's ID (5 -> 8 letters): ");
            String value = input.nextLine();  // get input

            if (value.length() < 5 || value.length() > 8) {  // search value must (5 < x < 8)
                System.out.println("Only 5 to 8 letters!");
                partialSearch(arr);
            }

            // calculate number of 0 need to add
            double zero = Math.pow(10, 10 - value.length());
            String target = value + String.valueOf((int) zero).substring(1);  // convert to string and add to input

            // binarySearch to find matching value
            int index = indexSearch(arr, target, value);

            if (index == -1) {  // no matching
                System.out.println("\nUser not found\n");
                return;
            }

            // loop forward and backward for matching value
            System.out.println(arr.get(index));
            valueSearch(arr, index, value);
        }

}
