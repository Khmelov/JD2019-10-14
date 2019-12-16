package by.it.baranovskaya.jd01_04;

import java.util.Scanner;

public class InOut {
    static double[] getArray(String line) {
        String[] strArray = line.split(" ");
        double[] array = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Double.parseDouble(strArray[i]);
        }
        System.out.println();
        return array;
    }
    static void printArray(double[ ] array) {
        for (double element: array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("%1s[ %d ]=%-8.2f ", name, i, arr[i]);
            if ((i+1)%columnCount==0 || i+1 == arr.length) {
                System.out.println();
            }
        }
    }
}
