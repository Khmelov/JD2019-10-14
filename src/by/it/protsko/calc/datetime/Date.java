package by.it.protsko.calc.datetime;

import by.it.protsko.calc.lang_operations.ResurceManager;

import java.text.DateFormat;

public class Date {
    private static DateFormat date;

    private static String currentDate() {
        date = DateFormat.getDateInstance(DateFormat.LONG, ResurceManager.INSTANSE.getCurrentLocale());
        return date.format(new java.util.Date());
    }

    public static String getCurrentDate() {
        return currentDate();
    }
}
