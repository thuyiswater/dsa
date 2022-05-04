package com.data;

import com.features.AddCustomer;
import java.io.*;

public class DataHandler {
    public static void readFile(MyArrayList s) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\Downloads\\10mil.txt")); // read file
        reader.readLine(); // skip 1st line
        String row;


        // read each line from the 2nd one
        while ((row = reader.readLine()) != null) { // still got data after
            String[] splitData = row.split(",");
            Customer cus = new Customer();
            cus.setID(splitData[0]);
            cus.setFirstName(splitData[1]);
            cus.setLastName(splitData[2]);
            cus.setPhone(splitData[3]);
            s.add(cus);

        }
        reader.close();
    }
}
