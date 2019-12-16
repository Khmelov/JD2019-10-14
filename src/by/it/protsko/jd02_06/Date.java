package by.it.protsko.jd02_06;

import java.text.DateFormat;
import java.util.Locale;

class Date {


    private static String currentDate() {
        DateFormat date = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
        return date.format(new java.util.Date());
    }

    static String getCurrentDate() {
        return currentDate();
    }
}
