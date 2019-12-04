package by.it.konovalova.jd01_13;

import java.util.HashMap;

public class TaskA {

    public static void main(String[] args)  {

        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement.getClassName().equals(TaskA.class.getName())) {
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
