package by.it.baranovskaya.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private String path="by.it.baranovskaya.jd02_05.lang.translate";

    private ResourceBundle rb;

    public Locale getLocale() {
        return locale;
    }

    private Locale locale;

    ResMan() {
        setLocale(Locale.getDefault());
    }

    void setLocale(Locale locale){
        this.locale = locale;
        rb = ResourceBundle.getBundle(path,this.locale);
    }



    String get(String key){
        return rb.getString(key);
    }
}
