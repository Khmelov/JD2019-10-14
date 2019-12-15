package by.it.akhmelev.jd02_06;

import by.it.akhmelev.jd01_14.TaskA;

import java.io.*;

class Logger {

    private static volatile Logger instanse;

    private Logger() {
    }

    static Logger get() {

        if (instanse == null) {

            synchronized (Logger.class) {
                if (instanse == null) {
                    instanse = new Logger();
                }
            }
        }
        return instanse;
    }

    private String filename = getPath(Logger.class) + "log.txt";

    void log(String text) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
            out.append(text).append("\n");
        } catch (IOException e) {
            System.out.println("What?");
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
