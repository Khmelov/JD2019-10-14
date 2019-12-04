package by.it.toporova.jd01_13;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        //В классе TaskBнапишите цикл, который:
        //считывает данные из консоли построчнои закрывается при вводе в консоль слова END;
        //переводит каждую строку в вещественное числои выводит в консоль данное число и корень
        // из суммы всех ранее введенных чисел, включая введенное;
        //если перевести ввод в число невозможно, то программа перехватывает полученную ошибку и
        // показывает сообщение в консоли сообщение, такого же формата, как в предыдущем задании
        //если невозможно извлечь корень, то обработка аналогична, но тип ошибки -ArithmeticException

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