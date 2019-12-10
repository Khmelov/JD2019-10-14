package by.it.protsko.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskC {
    private static Scanner sc;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
        readData();
    }

    private static void readData() throws Exception {
        List<Double> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            try {
                while (sc.hasNext()) {
                    String line = sc.next();
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