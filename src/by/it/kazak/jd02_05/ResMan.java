package by.it.kazak.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;
    private ResourceBundle rb;

    ResMan() {
        setLocale(Locale.getDefault());
    }

    void setLocale(Locale locale) {
        String path = "by.it.kazak.jd02_05.translate.translate";
        rb = ResourceBundle.getBundle(path, locale);
    }

    String get(String key) {
        return rb.getString(key);
    }
}
