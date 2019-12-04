package by.it.kharitonenko.jd01_14;

import java.io.*;

public class TaskC {
    public static StringBuilder result = new StringBuilder();

    private static String dir(Class<?> cl) {
        return System.getProperty("user.dir") + File.separator + ("src") +
                File.separator + cl.getName().
                replace(cl.getSimpleName(), "").
                replace(".", File.separator).
                replace("jd01_14\\", "");
    }

    private static String dir2(Class<?> cl) {
        return System.getProperty("user.dir") + File.separator + ("src") +
                File.separator + cl.getName().
                replace(cl.getSimpleName(), "").
                replace(".", File.separator);
    }

    static String printFilesDirectories(String rootDirectory) {
        File currentDirectory = new File(rootDirectory);
        File[] listOfFiles = currentDirectory.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                result.append("file:" + file.getName() + "\n");
                System.out.println("file:" + file.getName());
            } else if (file.isDirectory()) {
                result.append("dir:" + file.getName() + "\n");
                System.out.println("dir:" + file.getName());
                printFilesDirectories(file.getAbsolutePath());
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        try (PrintWriter output = new PrintWriter
                (new FileWriter(dir2(TaskC.class) + "resultTaskC.txt"))){
            printFilesDirectories(dir(TaskC.class));
            output.append(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
