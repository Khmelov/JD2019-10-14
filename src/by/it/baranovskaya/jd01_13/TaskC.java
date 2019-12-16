package by.it.baranovskaya.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private static Scanner scan;

    public static void main(String[] args) throws Exception {
        scan = new Scanner(System.in);
        readData();
    }

    private static void readData() throws Exception {
        List<Double> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            try {
                while (scan.hasNext()) {
                    String line = scan.next();
                    list.add(Double.valueOf(line));
                }
            } catch (NumberFormatException e) {
                Thread.sleep(100);
            }
            printReverseList(list);
        }
        throw new NumberFormatException();
    }

    private static void printReverseList(List<Double> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
