package by.it.protsko.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {

    private static Logger loggerInstance;
    private final String logFileName = getPath(Logger.class) + "log.txt";

    private Logger() {
    }

    public static Logger getLoggerInstanceInstanse() {
        Logger localInstance = loggerInstance;
        if (localInstance == null) {
            synchronized (Logger.class) {
                localInstance = loggerInstance;
                if (localInstance == null) {
                    loggerInstance = localInstance = new Logger();
                }
            }
        }
        return localInstance;
    }

    void logMessages(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFileName, true))) {
            writer.print(message + "\n");
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
