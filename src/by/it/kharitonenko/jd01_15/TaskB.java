package by.it.kharitonenko.jd01_15;

import java.io.*;

public class TaskB {
    /**
     * Finds and returns as String value the directory of class.
     *
     * @param cl class name
     * @return directory in which cl resides
     */
    private static String dir(Class<?> cl) {
        return System.getProperty("user.dir") + File.separator + ("src") +
                File.separator + cl.getName().
                replace(cl.getSimpleName(), "").
                replace(".", File.separator);
    }

    private static void deleteComments(StringBuilder sourceCode) {
        int start;
        int end;
        while ((start = sourceCode.indexOf("/\u002f")) >= 0 && (end = sourceCode.indexOf("\n", start)) >= 0) {
            sourceCode.delete(start, end);
        }
        while ((start = sourceCode.indexOf("\u002f*")) >= 0 && (end = sourceCode.indexOf("*\u002f")) >= 0) {
            sourceCode.delete(start, end + 2);
        }
    }

    //string builder method
    static void readSource() {
        StringBuilder sourceText = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(dir(TaskB.class) + "TaskB.java"));
             PrintWriter writer = new PrintWriter(new FileWriter(dir(TaskB.class) + "TaskB.txt"))) {
            String temp;
            while ((temp = reader.readLine()) != null) {
                sourceText.append(temp).append("\n");
            }
            deleteComments(sourceText);
            System.out.println(sourceText);
            writer.print(sourceText);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    comments
     */
    public static void main(String[] args) {
        /*
        more comments
         */
        readSource();
    }
}