package com.features;

import java.util.*;
import com.data.*;

public class UpdateCustomer {
    static Scanner sc = new Scanner(System.in);
    public static void updateCustomer(MyArrayList<Customer> arr) throws Exception {
        System.out.print("\nPlease enter customer's ID: ");
        String input = sc.nextLine();

        // check if user exist
        int index = Search.binarySearch(arr, input);
        // do nothing if user not exist
        if (index == -1) {
            return;
        }

        System.out.println("Customer found!");
        // sub menu
        while (true) {
            System.out.print("""
                       \nWhich field do you want to update
                       1. First name
                       2. Last name
                       3. Phone number
                       4. Exit
                       Select an option by enter a number:\s""");
            int option = sc.nextInt();

            // option 1 = set new first name
            if (option == 1) {
                System.out.print("\nEnter new first name: ");
                arr.get(index).setFirstName(sc.next());
                System.out.println("Update successfully");
                Buffer.buff();
            }
            // option 2 = set new last name
            else if (option == 2) {
                System.out.print("\nEnter new last name: ");
                arr.get(index).setLastName(sc.next());
                System.out.println("Update successfully");
                Buffer.buff();
            }
            // option 3 = set new phone no.
            else if (option == 3) {
                System.out.print("\nEnter new phone number: ");
                arr.get(index).setPhone(sc.next());
                System.out.println("Update successfully");
                Buffer.buff();
            }
            // return to main menu
            else break;
        }
    }
}
