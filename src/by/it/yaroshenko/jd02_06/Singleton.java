package by.it.yaroshenko.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Singleton {
    private static volatile Singleton instance;
    private static String filemane = getPath(Singleton.class) + "logger.txt";


    public Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    void addLogFile(String text) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filemane, true))) {
            printWriter.append(text).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(Class<?> aClass) {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator +
                aClass
                        .getName()
                        .replace(aClass.getSimpleName(), "")
                        .replace(".", File.separator);
    }


}
