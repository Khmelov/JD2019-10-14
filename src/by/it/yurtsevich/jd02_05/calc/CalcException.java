package by.it.yurtsevich.jd02_05.calc;


import by.it.yurtsevich.jd02_05.Errors;
import by.it.yurtsevich.jd02_05.ResourceManager;

public class CalcException extends Exception {
    private static ResourceManager resourceManager=ResourceManager.INSTANCE;
    public CalcException() {
    }

    public CalcException(String message) {
        super(resourceManager.get(Errors.ERROR)+ message);
    }

    public CalcException(String message, Throwable cause) {
        super(resourceManager.get(Errors.ERROR)+ message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR:"+ message, cause, enableSuppression, writableStackTrace);
    }
}
