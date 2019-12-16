package by.it.zabauniuk.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {

    private static Scanner scanner;
    private static int counter = 0;
    private static List<Double> list = new ArrayList<>();

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        for(;;) {
            readData();
        }
    }

    private static void readData() throws NumberFormatException {
        String strValue = scanner.next();
        try {
            Double newEntry = Double.valueOf(strValue);
            list.add(newEntry);
        } catch (NumberFormatException e) {
            if (counter < 5) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
                counter++;
            } else throw new NumberFormatException();
        }
    }
}