package by.it.bodukhin.jd01_15;

import java.io.*;


// комментарий

public class TaskB {
    public static void main(String[] args) {
        String path = getPath(TaskB.class);
        String filename = path + "TaskB.java";
        StringBuilder sb = new StringBuilder();
        writeToSb(filename, sb);
        deleteComments(sb);
        System.out.println(sb);
        printToFile(path, sb);
    }

    /**
     *
     * @param path
     * @param sb
     */

// 2ой комментарий

    private static void printToFile(String path, StringBuilder sb) {
        try (PrintWriter out = new PrintWriter(
                path + "TaskB.txt")
        ) {
            out.print(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param sb
     */

    private static void deleteComments(StringBuilder sb) {
        int start, end;
        while ((start = sb.indexOf("//"))>=0 && (end = sb.indexOf("\n",start))>=0){
            sb.delete(start, end);
        }
        while ((start = sb.indexOf("/*"))>=0 && (end = sb.indexOf("*/"))>=0){
            sb.delete(start, end+2);
        }
    }

/* 1й комментарий
на 2 строки */

    /**
     *
     * @param filename
     * @param sb
     */
    private static void writeToSb(String filename, StringBuilder sb) {
        boolean del = false;
        try (
                BufferedReader br = new BufferedReader(
                        new FileReader(filename))
        ) {
            while (br.ready()) {
               sb.append(br.readLine()).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param bClass
     * @return
     */

/* 2й комментарий
на 2 строки */

    private static String getPath(Class<TaskB> bClass) {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator +
                bClass
                        .getName()
                        .replace(bClass.getSimpleName(), "")
                        .replace(".", File.separator);
    }
}