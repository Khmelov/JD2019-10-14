package by.it.protsko.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

class TaskB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> numbersList = new ArrayList<>();
        double sum = 0;

        try {
            for (; ; ) {
                String line = sc.nextLine();
                if (line.equals("END")) {
                    break;
                } else {
                    numbersList.add(Double.valueOf(line));
                }
            }
            for (Double number : numbersList) {
                sum += number;
                double sqrt = Math.sqrt(sum);
                if (!Double.isNaN(sqrt)) {
                    System.out.println(number + " " + Math.sqrt(sum));
                } else {
                    throw new ArithmeticException();
                }
            }
        } catch (ArithmeticException | NumberFormatException e) {
            int lineNumber = 0;
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                lineNumber = element.getLineNumber();
            }
            System.out.println(" name: " + e.getClass().getName() + "\n" + "class: " + TaskB.class.getName() + "\n" + "line: " + lineNumber);
        }
    }
}