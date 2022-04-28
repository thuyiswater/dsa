package com.data;

import com.features.AddCustomer;
import java.io.*;

public class DataHandler {


        public static void readFile(String[] s) throws Exception {

            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\Downloads\\10mil.txt")); // read file
            reader.readLine(); // skip 1st line
            String row;

            // read each line from the 2nd one
            while ((row = reader.readLine()) != null) { // still got data after

                String[] splitData = row.split(", ");

//
            }
            reader.close();

        }

        public static void convertToObj(String[] s) {
        }

//        public static void writeFile(MyArrayList<Customer> arr) throws Exception {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\IntellJ\\IdeaProjects\\dsa\\src\\com\\data\\customer.csv"));
//            writer.write("customer_id,firstname,lastname,phone");
//
//            for (int i = 0; i < arr.size(); i++) {
//                writer.newLine();
//                writer.write(arr.get(i).getID() + "," + arr.get(i).getFirstName() + "," + arr.get(i).getLastName() + "," + arr.get(i).getPhone());
//            }
//            writer.close();
//        }
}
