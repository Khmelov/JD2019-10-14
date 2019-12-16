package by.it.yaroshenko.jd02_06;

import java.lang.reflect.Field;
import java.util.Date;

public class Runner {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        instance.addLogFile(dataAndTimeLog()+ " Hi!");
        Singleton.getInstance().addLogFile(dataAndTimeLog()+ " By!");

    }

    private static String dataAndTimeLog() {
        Date date = new Date();
        return date.toString();
    }



}
