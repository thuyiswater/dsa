package com.data;

import java.util.Scanner;

public class Buffer {
    /* this function is perform as a pause button
    to let the user catch up with the progress
     */
    public static void buff() throws Exception {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Press 0 to continue... ");
        int option = myObj.nextInt();
    }
}
