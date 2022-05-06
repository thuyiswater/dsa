package com.company;

import java.util.*;
import com.data.*;
import com.features.AddCustomer;
import com.features.Search;
import com.features.UpdateCustomer;

public class Main {

    public static void main(String[] args) throws Exception{
        MyArrayList<Customer> customerList = new MyArrayList<>();
        DataHandler.readFile(customerList);
        MergeSort ms = new MergeSort();
        int n = customerList.size();

        ms.qSort(customerList, 0, n - 1);

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("\n\t\t\t\t\t Welcome to Record Management for Intelligent Tracking (RMIT)");
            System.out.println("Menu: ");
            System.out.print("""
                    1. Add a new customer
                    2. Update an existing customer
                    3. Search for customers
                    4. Exit
                    """);
            System.out.print("\nPlease select an option by enter the number: ");
            int option = input.nextInt();

            switch (option) {
                case 1 -> {
                    AddCustomer.insert(customerList);
                    Buffer.buff();
                }
                case 2 -> {
                    UpdateCustomer.updateCustomer(customerList);
                    Buffer.buff();
                }
                case 3 -> {
                    System.out.println("\nSearch type: ");
                    System.out.println("1. Search for one customer");
                    System.out.println("2. Search for a list of customer");
                    System.out.print("\nPlease select an option by enter the number: ");
                    Scanner input2 = new Scanner(System.in);
                    int option2 = input2.nextInt();

                    if (option2 == 1) {
                        Search.exactSearch(customerList);
                    } else {
                        Search.partialSearch(customerList);
                    }
                    Buffer.buff();
                }
                case 4 -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Invalid option");
                    System.exit(0);
                }
            }
        }
    }
}
