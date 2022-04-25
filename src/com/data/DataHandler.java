package com.data;

import com.features.AddCustomer;
import java.io.*;

public class DataHandler {

        public static void readFile(MyArrayList<Customer> arr) throws Exception {

            // an array to store all customers
            BufferedReader reader = new BufferedReader(new FileReader("D:\\IntellJ\\IdeaProjects\\dsa\\src\\com\\data\\customer.csv")); // read file
            reader.readLine(); // skip 1st line
            String line = reader.readLine(); // read 2nd line

            // read each line
            while (line != null) { // still got data after

                String[] splitData = line.split(",");
                Customer tempCus = new Customer(splitData[0], splitData[1], splitData[2], splitData[3]); // assign splitted
                // data to object

                // CustomersList.add(tempCus);
                AddCustomer.add(arr, tempCus); // add to MyArrayList
                line = reader.readLine(); // read next line
            }
            reader.close();
        }

        public static void writeFile(MyArrayList<Customer> arr) throws Exception {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\IntellJ\\IdeaProjects\\dsa\\src\\com\\data\\customer.csv"));
            writer.write("customer_id,firstname,lastname,phone");

            for (int i = 0; i < arr.size(); i++) {
                writer.newLine();
                writer.write(arr.get(i).getID() + "," + arr.get(i).getFirstName() + "," + arr.get(i).getLastName() + "," + arr.get(i).getPhone());
            }
            writer.close();
        }
}
