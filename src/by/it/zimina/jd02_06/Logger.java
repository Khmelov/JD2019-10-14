package by.it.zimina.jd02_06;


class Logger {

    private volatile Logger instanse;

    private Logger() {

    }

    Logger get() {
        if (instanse == null) {
            synchronized (Logger.class) {
                if (instanse == null) {
                    instanse = new Logger();
                }
            }
        }
        return instanse;
    }

    void log(String text){};
}
