package by.it.kazak.calc;

public class CalcException extends Exception {

    public CalcException() {
    }

    public CalcException(String message) {
        super("ERROR:"+message);
        Logger.get().log(message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR:"+message, cause);
        Logger.get().log(message);
    }

    public CalcException(Throwable cause) {
        super(cause);
        Logger.get().log(String.valueOf(cause));
    }
}
