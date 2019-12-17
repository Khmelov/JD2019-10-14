package by.it.zimina.jd02_06;

public class Client {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        logger.log("I am the main thread");
        for (int i = 1; i <= 5; i++) {
            new ClientThread("thread " + i).start();
        }
    }
}