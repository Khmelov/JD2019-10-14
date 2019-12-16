package by.it.konovalova.calc;


public class CalcException extends Exception{
    public CalcException() {
    }

    public CalcException(String message) {
        super("ERROR: "+message);
        Logger.get().log("ERROR: "+message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: "+message, cause);
        Logger.get().log("ERROR: "+message.concat(cause.toString()));
    }

    public CalcException(Throwable cause) {
        super(cause);
        Logger.get().log(cause.toString());
    }


}
