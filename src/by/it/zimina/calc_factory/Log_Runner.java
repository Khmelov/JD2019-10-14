package by.it.zimina.calc_factory;

public class Log_Runner {
    public static void main(String[] args) {

        Logger.get().log("Hi!"+ " " + Logger.timeFormat());
        Logger.get().log("By!"+ " " + Logger.timeFormat());
    }
}
