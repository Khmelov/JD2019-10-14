package by.it.volchek.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

/*В классе TaskB напишите цикл, который:
 считывает данные из консоли построчно и закрывается при вводе в консоль слова END;
 переводит каждую строку в вещественное число и выводит в консоль данное число
и корень из суммы всех ранее введенных чисел, включая введенное;
 если перевести ввод в число невозможно, то программа перехватывает полученную ошибку и
показывает сообщение в консоли сообщение, такого же формата, как в предыдущем задании
 если невозможно извлечь корень, то обработка аналогична, но тип ошибки - ArithmeticException
name:java.lang.NullPointerException
class: by.it.вашпакет.jd01_13.TaskA
line: 8
*/
public class TaskB {
    private static void err (Exception e) {
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
        Scanner sc=new Scanner (System.in);
        ArrayList<Double> list = new ArrayList<>();
        String word;
       try {
           for (; ; ) {
               word = sc.next();
               if (word.equals("END")) break;
               list.add(Double.parseDouble(word));
               System.out.println(word);
               Double sum = list.stream().reduce((s1, s2) -> s1 + s2).orElse(0.0);
               if (sum<0)err(new ArithmeticException());
               else
               System.out.println(Math.sqrt(sum));
           }
       } catch (NumberFormatException e) {
           err(e);
       }
    }
}
