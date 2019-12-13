package by.it.komarov.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

class Logger {
    private static Logger instance;

    private Logger(){}

    static Logger getInstance(){
        Logger localeInstance = instance; // попытка получить объект
        if (localeInstance == null){
            synchronized (Logger.class){
                localeInstance = instance;
                if(localeInstance == null){
                    instance = localeInstance = new Logger();
                }
            }
        }
        return instance;
    }

    private static String filename = getPath(Logger.class) + "log.txt";

    void log(String text) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
            out.append(text).append("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void printExeptionInFile(String text) {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(filename, true));
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
        try {
            throw new Exception();
        } catch (Exception ex) {
            out.printf("\n%s: %s\n", LocalDateTime.now(), ex.getMessage());
            ex.printStackTrace(out);
            out.flush();
        }
    }

    private static String getPath(Class<?> aClass){
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator
                + aClass
                        .getName()
                        .replace(aClass.getSimpleName(), "")
                        .replace(".", File.separator);

    }

}
