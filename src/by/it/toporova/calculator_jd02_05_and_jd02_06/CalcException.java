package by.it.toporova.calculator_jd02_05_and_jd02_06;
import by.it.toporova.calculator_jd02_05_and_jd02_06.lang.strings.Errors;

public class CalcException extends Exception {

    public CalcException() {
        super();
    }

    public CalcException(String message) {
        super(ResMan.INSTANCE.get(Errors.ERROR) + " " + message);
        System.out.println(ResMan.INSTANCE.get(Errors.ERROR) + " " + message);
    }

    public CalcException(String message, Throwable cause) {
        super(ResMan.INSTANCE.get(Errors.ERROR) + " " + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}