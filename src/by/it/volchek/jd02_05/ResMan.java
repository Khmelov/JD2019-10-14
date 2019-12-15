package by.it.volchek.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private String path="by.it.volchek.jd02_05.lang.translate";

    private ResourceBundle rb;

    private Locale locale;

    ResMan() {
        setLocale(Locale.getDefault());
    }

    void setLocale(Locale locale){
        this.locale=locale;
        rb=ResourceBundle.getBundle(path,this.locale);
    }

    Locale getLocale() {
        return locale;
    }

    String get(String key){
        return rb.getString(key);
    }

}
