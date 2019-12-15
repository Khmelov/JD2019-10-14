package by.it.toporova.jd02_05_refactored;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private String path="by.it.toporova.jd02_05.lang.translate";

    private ResourceBundle rb;

    private Locale locale;

    ResMan() { setLocale(Locale.getDefault());}

    void setLocale(Locale locale){
        this.locale=locale;
        rb=ResourceBundle.getBundle(path, this.locale);
    }

    void setLocale(String language, String country){
        setLocale(new Locale(language, country));
    }
    void getLocalDate(){
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        Date currentDate = new Date();
        System.out.println(dateFormat.format(currentDate));
    }

    String get(String key) {return rb.getString(key);}
}

