package by.it.bodukhin.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class Logger {

    private static volatile Logger instanse;

    private Logger(){
    }

    static Logger get() {
        if(instanse == null) {
            synchronized (Logger.class) {
                if(instanse==null){
                    instanse= new Logger();
                }
            }
        }
        return instanse;
    }

    private String filename = getPath(Logger.class) + "log.txt";

    void log(String text) {
        try(PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
            out.append(text).append(" ").append(LocalDate.now().toString()).append(" ")
                    .append(LocalTime.now().toString()).append("\n");
        } catch (IOException e) {
            System.out.println("Error");
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

