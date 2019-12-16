package by.it.protsko.jd02_06;

import java.time.LocalDateTime;

public class Runner {

    public static void main(String[] args) {
        Logger logger = Logger.getLoggerInstanceInstanse();
        logger.logMessages(LocalDateTime.now() + ": " + "Error: ....");
        logger.logMessages(LocalDateTime.now() + ": " + "Exception: ....");
    }
}
