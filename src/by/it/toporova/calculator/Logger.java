package by.it.toporova.calculator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


class Logger {
    private static volatile Logger instance;

    private static String filename;

    private Logger() {
        filename = System.getProperty("user.dir") +
                "/src/by/it/toporova/calculator/log.txt";
    }

    static Logger getLogger() {
        if(instance==null){
            synchronized (Logger.class){
                if (instance==null)
                    instance = new Logger();
            }
        }
        return instance;
    }

    void toLog(String logLine) {
        Date date = new Date();
        String message = String
                .format("%s %s\n", date.toString(), logLine);
        synchronized (Logger.class) {
            try (
                    BufferedWriter out =
                            new BufferedWriter(
                                    new FileWriter(filename, true)
                            )
            ) {
                out.write(message);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
