package by.it.toporova.jd02_05;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private String path="by.it.toporova.jd02_05.lang.translate";

    private ResourceBundle rb;

    private Locale locale;


    ResMan(){
        setLocale(Locale.getDefault());
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        rb=ResourceBundle.getBundle(path,locale);
    }

    public void setLocale(String language) {
        setLocale(new Locale(language));
    }

    public void setLocale(String language, String country) {
        setLocale(new Locale(language,country));
    }

    public String get(String key){
        return rb.getString(key);
    }
}
