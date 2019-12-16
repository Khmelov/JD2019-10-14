package by.it.protsko.calc;

import by.it.protsko.calc.log.Logger;
import by.it.protsko.calc.lang_operations.CalcExpMessages;
import by.it.protsko.calc.lang_operations.ResurceManager;

class CalcException extends Exception {
    private Logger logger;

    public CalcException() {
    }

    public CalcException(String message) {
        super(ResurceManager.INSTANSE.getMessage(CalcExpMessages.ERR) + message);
//        logger.logMessages(ResurceManager.INSTANSE.getMessage(CalcExpMessages.ERR) + message);
    }

    public CalcException(String message, Throwable cause) {
        super(ResurceManager.INSTANSE.getMessage(CalcExpMessages.ERR) + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
