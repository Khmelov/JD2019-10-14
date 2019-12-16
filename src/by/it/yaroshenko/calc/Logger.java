package by.it.yaroshenko.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {
    private static volatile Logger instance;
    private static String filemane = getPath(Logger.class) + "logger.txt";


    public Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
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

    static String dataAndTimeLog() {
        Date date = new Date();
        return date.toString();
    }
}
