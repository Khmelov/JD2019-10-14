package by.it.komarov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private ResourceBundle resourceBundle;
    private final String resourseName = "by.it.komarov.jd02_05.lang.translate";
    private Locale locale;

    ResMan() {
        resourceBundle = ResourceBundle.getBundle(resourseName, Locale.getDefault());
    }

    void setLocale(Locale locale){
        resourceBundle = ResourceBundle.getBundle(resourseName, this.locale);
    }
    String get(String key) {
        return resourceBundle.getString(key);
    }
}
