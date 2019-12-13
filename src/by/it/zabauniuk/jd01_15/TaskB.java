package by.it.zabauniuk.jd01_15;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        String filename = getPath(TaskB.class) + TaskB.class.getSimpleName() + ".java";
        String wrFilename = getPath(TaskB.class) + TaskB.class.getSimpleName() + ".txt";
        System.out.println(filename);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
             PrintWriter outFile = new PrintWriter(new FileWriter(wrFilename))) {
            char ch, ch1;
            while (bufferedReader.ready()) {
                ch = (char)bufferedReader.read();
                if (ch == '/') {
                    ch1 = (char)bufferedReader.read();
                    if (ch1 == '/')
                        while ((ch = (char)bufferedReader.read()) != '\n');
                    else if (ch1 == '*') {
                        while ((char) bufferedReader.read() != '*' || (char) bufferedReader.read() != '/') ;
                        continue;
                    }
                    else {
                        stringBuilder.append(ch).append(ch1);
                        outFile.print(ch);
                        outFile.print(ch1);
                        continue;
                    }
                }
                stringBuilder.append(ch);
                outFile.print(ch);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        System.out.println(stringBuilder);
    }


    private static String getPath(Class<?> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String subPath = taskAClass.getName().replace(".", File.separator).replace(taskAClass.getSimpleName(), "");
        String path = rootProject + File.separator + "src" + File.separator + subPath;
        return path;
    }
}