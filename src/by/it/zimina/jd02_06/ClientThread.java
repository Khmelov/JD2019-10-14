package by.it.zimina.jd02_06;

public class ClientThread extends Thread {

    ClientThread(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        Logger logger = Logger.getLogger();
        logger.log("I am " + this.getName());
    }
}