package by.it.zabauniuk.jd01_13;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;
        Double[] array = new Double[0];
        double sum = 0;

        for (; ; ) {
            text = scanner.nextLine();
            if (text.equals("END")) break;

            try {
                double number = Double.parseDouble(text);
                System.out.println(number);

                array = Arrays.copyOf(array, array.length + 1);
                array[array.length - 1] = number;

                sum = number + sum;
                double sqrt = Math.sqrt(sum);
                System.out.println(sqrt);
                if (sum < 0) {
                    throw new ArithmeticException();
                }

            } catch (ArithmeticException | NumberFormatException e) {
                String name = e.getClass().getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    String className = element.getClassName();
                    int lineNumber = element.getLineNumber();
                    if (className.contains("TaskB")) {
                        System.out.printf("name:  %s%n" +
                                "class: %s%n" +
                                "line:  %s%n", name, className, lineNumber);
                    }
                }
            }

        }

    }
}