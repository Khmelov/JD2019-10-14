package by.it.konovalova.jd01_15;

import java.io.*;


public class TaskB {


    public static void main(String[] args) {
        String path = getPath();
        String filename = path + ".java";
        StringBuilder sb = new StringBuilder();
        readText(path, sb); // Читаем текст
        printToConsole(sb); // Выводим текст на консоль
        printToFile(path, sb); // Печатаем текст в файл
    }

    /**
     * Метод, который читает файл, в котором он создан
     *
     * @param path
     * @param sb
     */
    private static void readText(String path, StringBuilder sb) {
        try (BufferedReader dis = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path + ".java")))) {
            while (dis.ready()) {
                sb.append(dis.readLine()).append("\n");
            }
            char c1='/';
            char c2='*';
            String s1=Character.toString(c1)+Character.toString(c1);
            String s2=Character.toString(c1)+Character.toString(c2);
            String s3=Character.toString(c2)+Character.toString(c1);
            while (sb.indexOf(s2) >= 0) {
                sb.delete(sb.indexOf(s2), sb.indexOf(s3) + 2);
            }
            while (sb.indexOf(s1) >= 0 && (sb.indexOf("\n", sb.indexOf(s1)) >= 0)) {
                sb.delete(sb.indexOf(s1), sb.indexOf("\n", sb.indexOf(s1)) );
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }


    private static void printToConsole(StringBuilder sb) {
        /*
        При выводе на консоль будем выводить StringBuilder уже без комментариев
         */
        System.out.println(sb);
    }

    private static void printToFile(String path, StringBuilder sb) {
        try (PrintWriter out = new PrintWriter(new FileWriter(path + ".txt"))) {
            out.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath() {
        /*
          Находим путь к файлу
         */
        return System.getProperty("user.dir") + File.separator + "src" + File.separator
                + TaskB.class.getName().
                replace(".", File.separator);
    }
}
