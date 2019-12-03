package by.it.kazak.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();
        try {
            while (scanner.hasNext()) {
                String next = scanner.next();
                if (next.equals("END")) break;
                Double number = Double.parseDouble(next);
                list.add(number);
            }
            for (int i = 0; i < list.size(); i++) {
                Double num = list.get(i);
                int sum = 0;
                for (int j = 0; j <= i; j++) {
                    Double integer = list.get(j);
                    sum+=integer;
                }
                if (sum<0) throw new ArithmeticException();
                double sqrt = Math.sqrt(sum);
                System.out.println(num);
                System.out.println(sqrt);
            }
        } catch (NumberFormatException | ArithmeticException e) {
            String name = e.getClass().getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                String className = element.getClassName();
                int lineNumber = element.getLineNumber();
                if (className.equals(TaskB.class.getName())) {
                    System.out.printf(" name: %s\n" + "class: %s\n" + " line: %s\n", name, className, lineNumber);
                }
            }
        }
    }
}
