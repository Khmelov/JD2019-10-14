package by.it.zabauniuk.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

class Logger {

    private String path = PathGenerator.getPath(Logger.class);
    private String filename = "log.txt";
    private String fullPath = path + filename;

    private Logger() {

    }

    private static volatile Logger logger;

    static Logger getLogger() {
        Logger loggerLocal = logger;
        if (loggerLocal == null) {
            synchronized (Logger.class) {
                loggerLocal = logger;
                if (loggerLocal == null) {
                    logger = new Logger();
                    loggerLocal = logger;
                }
            }
        }
        return loggerLocal;
    }

    private String stringDate = getDate();
    private String stringTime = getTime();

    synchronized void log(String message) {
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(fullPath, true))) {
            printWriter.println(stringDate + " " + stringTime + " LOG: " + message);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getDate() {
        Instant now = Instant.now();
        Date date = Date.from(now);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        return dateFormat.format(date);
    }

    private String getTime() {
        LocalTime localTime = LocalTime.now();
        return localTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
    }

}