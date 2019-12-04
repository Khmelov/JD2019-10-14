package by.it.sermyazhko.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        double x = Math.sqrt(-1.0);
        System.out.println(x);

        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (element.getClassName().equals(TaskA.class.getName())) {
                    int lineNumber = element.getLineNumber();
                    String className = element.getClassName();
                    System.out.printf(" name:%s\nclass:%s\n line:%d\n",
                            e.getClass().getName(),
                            className,
                            lineNumber);
                    break;
                }
            }
        }
    }

}
