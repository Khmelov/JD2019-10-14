package by.it.zabauniuk.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "V", 3);
        System.out.println("min=%f, max=%f, Helper.findMin(array), Helper.findMax(array)");
        System.out.println();
        Helper.sort(array);
        InOut.printArray(array);

    }
}