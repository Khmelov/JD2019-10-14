package by.it.konovalova.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class TaskB {

    public static void main(String[] args) throws ArithmeticException {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        List<Integer> value = new ArrayList<>();
        int sum = 0;
        for (; ; ) {
            String text = sc.nextLine();
            if (text.equals("END"))
                break;
            sb.append(text).append(" ");
        }
        Pattern pattern = compile("[-A-Za-z1-9]+");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            String word = matcher.group();
            String[] arr = word.split("\\n");

            try {
                for (int i = 0; i < arr.length; i++) {
                    value.add(i, Integer.parseInt(arr[i]));
                    sum = sum + value.get(i);
                    if (value.get(i) <= 0 && sum <= 0)
                        throw new ArithmeticException();
                    else
                        System.out.println(value.get(i) + " " + Math.sqrt(sum));
                }
            } catch (NumberFormatException | ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement.getClassName().equals(TaskB.class.getName())) {
                        int line = stackTraceElement.getLineNumber();
                        String name = stackTraceElement.getClassName();
                        System.out.println(" name: " + e.getClass().getName());
                        System.out.println("class: " + name);
                        System.out.println(" line: " + line);
                        break;
                    }
                }
            }
        }
    }
}




