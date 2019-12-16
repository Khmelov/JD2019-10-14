package by.it.protsko.calc.log;

import by.it.protsko.calc.datetime.Date;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

public class Logger {

    private static Logger loggerInsrance;
    private static final String fileName = getPath(Logger.class) + "log.txt";

    private Logger() {
    }

    private static Logger getLoggerInsrance() {
        Logger localInsrance = loggerInsrance;
        if (localInsrance == null) {
            localInsrance = loggerInsrance;
            synchronized (Logger.class) {
                if (localInsrance == null) {
                    loggerInsrance = localInsrance = new Logger();
                }
            }
        }
        return localInsrance;
    }

    public static void logMessages(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.append(Date.getCurrentDate())
                    .append(" ")
                    .append(LocalTime.now().toString())
                    .append(" ")
                    .append(message)
                    .append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(Class<?> cClass) {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator
                + cClass
                .getName()
                .replace(cClass.getSimpleName(), "")
                .replace(".", File.separator);
    }
}
