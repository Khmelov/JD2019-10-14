package by.it.bodukhin.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private static String input;
    private static int count = 0;
    private static List<Double> numbers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (count!=6) {
            input = scanner.nextLine();
            readData();
        }
    }

    static void readData() throws Exception {
        try {
            double num = Double.parseDouble(input);
            numbers.add(num);
        } catch (NumberFormatException e) {
            if (count == 5) {
                throw new NumberFormatException();
            } else {
                Thread.sleep(100);
                for (int i = numbers.size() - 1; i > -1; i--) {
                    System.out.print(numbers.get(i) + " ");
                }
                System.out.println();
                count++;
            }
        }
    }
}
