package com.features;

import java.util.*;
import com.data.Customer;
import com.data.MyArrayList;
import com.data.Buffer;

public class UpdateCustomer {
    static Scanner sc = new Scanner(System.in);
    public static void updateCustomer(MyArrayList<Customer> arr) throws Exception {
        System.out.print("Please enter an user's ID: ");
        String input = sc.nextLine();

        // check if user exist in csv file
        int index = Search.binarySearch(arr, input);
        // notify if user not exist
        if (index == -1) {
            System.out.println("No user found");
            return;
        }

        while (true) {
            System.out.print("""
                       Which field do you want to update
                       1. First name
                       2. Last name
                       3. Phone
                       4. Exit
                       Select an option by enter a number:\s""");
            int option = sc.nextInt();

            Customer cus = new Customer();

            if (option == 1) {
                System.out.print("Enter new first name: ");
                cus.setFirstName(sc.nextLine());
                System.out.println("\nUpdate successfully");
                Buffer.buff();
            } else if (option == 2) {
                System.out.print("Enter new last name: ");
                cus.setLastName(sc.nextLine());
                System.out.println("Update successfully");
            } else if (option == 4) {
                break;
            }
        }
    }
}
