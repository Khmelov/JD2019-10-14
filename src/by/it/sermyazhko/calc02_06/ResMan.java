package by.it.sermyazhko.calc02_06;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private String path="by.it.sermyazhko.calc02_06.lang.translate";

    private ResourceBundle rb;

    public Locale getLocale() {
        return locale;
    }

    private Locale locale;

    ResMan() {
       setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale){
        this.locale = locale;
        rb = ResourceBundle.getBundle(path,this.locale);
    }



    String get(String key){
        return rb.getString(key);
    }

}
