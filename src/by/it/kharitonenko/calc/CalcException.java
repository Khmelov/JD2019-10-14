package by.it.kharitonenko.calc;

public class CalcException extends Exception {
    public CalcException() {
        super();
    }

    public CalcException(String message) {
        super(message);
        ConsoleRunner.logger.log(message);
    }

    public CalcException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
