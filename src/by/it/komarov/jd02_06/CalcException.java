package by.it.komarov.jd02_06;

public class CalcException extends Exception{

    public CalcException() {
    }

    CalcException(String message) {
        super("ERROR:" + message);
        Logger.get().log(message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR:"+message, cause);
        Logger.get().log(message);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
