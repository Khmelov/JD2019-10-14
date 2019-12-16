package by.it.sermyazhko.calc02_06;

class CalcException extends Exception{

    public CalcException() {
    }

    public CalcException(String message) {
        super(ResMan.INSTANCE.get(Messages.CALCERROR)+message);
        Logger.get().log(ResMan.INSTANCE.get(Messages.CALCERROR)+message);
    }

    public CalcException(String message, Throwable cause) {
        super(ResMan.INSTANCE.get(Messages.CALCERROR)+message, cause);
        Logger.get().log(ResMan.INSTANCE.get(Messages.CALCERROR)+message);
        Logger.get().log(cause.toString());
    }

    public CalcException(Throwable cause) {
        super(cause);
        Logger.get().log(cause.toString());
    }
}
