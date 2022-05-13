package com.company;

import java.util.*;
import com.data.*;
import com.features.*;

public class Main {

    public static void main(String[] args) throws Exception{

        MyArrayList<Customer> customerList = new MyArrayList<>();
        DataHandler.readFile(customerList);
        QuickSort qs = new QuickSort();
        qs.qSort(customerList, 0, customerList.size() - 1);

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("\n\t\t\t\t\t Welcome to Record Management for Intelligent Tracking (RMIT)");
            System.out.print("""
                    \nMenu:
                    1. Add a new customer
                    2. Update an existing customer
                    3. Search customer
                    4. Exit
                    """);
            System.out.print("Please select an option by enter the number: ");
            int option = input.nextInt();

            switch (option) {
                case 1 -> {
                    AddCustomer.insert(customerList);
                    Buffer.buff();
                }
                case 2 -> UpdateCustomer.updateCustomer(customerList);

                case 3 -> {
                    while (true) {
                        System.out.print("""
                                \nSearch type:
                                1. Search for one customer
                                2. Search for a list of customer
                                3. Exit
                                Select an option by enter a number:\s""");
                        Scanner input2 = new Scanner(System.in);
                        int option2 = input2.nextInt();

                        if (option2 == 1) {
                            Search.exactSearch(customerList);
                            Buffer.buff();
                        }
                        else if (option2 == 2){
                            Search.partialSearch(customerList);
                            Buffer.buff();
                        }
                        else break;
                    }
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
