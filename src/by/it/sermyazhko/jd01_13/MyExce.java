package by.it.sermyazhko.jd01_13;

class MyExce extends Exception{

    public MyExce() {
    }

    public MyExce(String message) {
        super("ERROR:"+message);
    }

    public MyExce(String message, Throwable cause) {
        super("MyException:"+message, cause);
    }

    public MyExce(Throwable cause) {
        super(cause);
    }

}
