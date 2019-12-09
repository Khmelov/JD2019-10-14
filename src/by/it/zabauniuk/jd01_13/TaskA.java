package by.it.zabauniuk.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args)  {
        double x = Math.sqrt(-5.0);
        System.out.println(x);

        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else Integer.parseInt("привет");

        }catch (NullPointerException | NumberFormatException e) {
            //Class<? extends RuntimeException> aClass = e.getClass();
            System.out.printf("name: %s\n", e.getClass().getName());
            System.out.printf("class: %s\n",  TaskA.class.getName());

            StackTraceElement[] elements = e.getStackTrace();
            for (StackTraceElement element : elements) {
                int lineNumber = element.getLineNumber();
                String className = element.getClassName();
                System.out.printf(" name:%s\nclass:%s\n line:%d\n",
                        e.getClass().getName(),
                        className,
                        lineNumber);

                Class<? extends StackTraceElement> aClass = element.getClass();
                if (element.getClassName().equals(TaskA.class.getName()))
                    System.out.println(element);
                break;
            }
        }
    }
}
