package by.it.protsko.jd01_13;

import java.util.HashMap;

class TaskA {

    public static void main(String[] args) {
        try {

            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else Integer.parseInt("привет");

        } catch (NullPointerException | NumberFormatException e) {
            int lineNumber = 0;
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                lineNumber = element.getLineNumber();
            }
            System.out.println(" name: " + e.getClass().getName() + "\n" + "class: " + TaskA.class.getName() + "\n" + "line: " + lineNumber);
        }
    }
}
