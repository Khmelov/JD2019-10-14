package by.it.yaroshenko.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;
    private String path = "by.it.yaroshenko.jd02_05.language.translate";
    private ResourceBundle rb;
    private Locale local;

    ResMan() {
        setLocal(Locale.getDefault());
    }
    void setLocal(Locale local) {
        this.local=local;
        rb=ResourceBundle.getBundle(path, this.local);
    }
    String get(String key) {
       return rb.getString(key);
    }
}
