package com.data;

import java.io.*;

public class DataHandler {
    public static void readFile(MyArrayList<Customer> s) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\IntellJ\\IdeaProjects\\Project_Group5\\dsa\\src\\com\\data\\customer.csv")); // read file
        reader.readLine(); // skip 1st line
        String row;

        // read each line from the 2nd one
        while ((row = reader.readLine()) != null) { // still got data after
            String[] splitData = row.split(",");
            Customer cus = new Customer(splitData[0], splitData[1], splitData[2], splitData[3]);
            s.add(cus);
        }
        reader.close();
    }
}