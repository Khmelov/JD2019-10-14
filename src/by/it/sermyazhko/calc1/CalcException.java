package by.it.sermyazhko.calc1;

public class CalcException extends Exception{

    public CalcException() {
    }

    public CalcException(String message) {
        super(ResMan.INSTANCE.get(Messages.CALCERROR)+message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR:"+message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
