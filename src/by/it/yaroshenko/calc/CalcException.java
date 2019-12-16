package by.it.yaroshenko.calc;

public class CalcException extends Exception {


    public CalcException() {
        super();
        Logger.getInstance().addLogFile(Logger.dataAndTimeLog() + this);
    }

    public CalcException(String message) {
        super("ERROR: " + message);
        Logger.getInstance().addLogFile(Logger.dataAndTimeLog() + " ERROR: " + message);

    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
        Logger.getInstance().addLogFile(Logger.dataAndTimeLog() + " ERROR: " + message + "\t" + cause);

    }

    public CalcException(Throwable cause) {
        super(cause);
        Logger.getInstance().addLogFile(cause.toString());

    }

    protected CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: " + message, cause, enableSuppression, writableStackTrace);
        Logger.getInstance().addLogFile(Logger.dataAndTimeLog() + " ERROR: " + message + "\t" + cause + "\t" + enableSuppression + "\t" + writableStackTrace);

    }


}
