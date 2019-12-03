package by.it.kharitonenko.jd01_13;

//*
//  считывает данные из консоли построчно и закрывается при вводе в консоль слова END;
//  переводит каждую строку в вещественное число и выводит в консоль данное число и корень из суммы всех
//   ранее введенных чисел, включая введенное;
//  если перевести ввод в число невозможно, то программа перехватывает полученную ошибку и показывает
//   сообщение в консоли сообщение, такого же формата, как в предыдущем задании
//  если невозможно извлечь корень, то обработка аналогична, но тип ошибки - ArithmeticException

import java.util.Scanner;

public class TaskB {

    private static void analyzeAndPrintException(Exception e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (TaskB.class.getName().equals(stackTraceElement.getClassName())) {
                System.out.println("name: " + e.getClass().getName());
                System.out.println("class: " + stackTraceElement.getClassName());
                System.out.println("line: " + stackTraceElement.getLineNumber());
            }
        }
    }

    public static void main(String[] args) {
        double sum = 0;
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String temp = scanner.next();
            if (temp.equals("END")) {
                break;
            }
            try {
                sum = sum + Double.parseDouble(temp);
                System.out.println(temp);
                if (Double.isNaN(Math.sqrt(sum))) throw new ArithmeticException();
                System.out.println(Math.sqrt(sum));
            } catch (Exception e) {
                analyzeAndPrintException(e);
            }
        }
    }
}

