package by.it.yurtsevich.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private String baseName;
    private ResourceBundle resourceBundle;
    private Locale locale;

    ResourceManager() {
        this.baseName = "by.it.zavadski.jd02_05.strings";
        setLocale(Locale.getDefault());
        resourceBundle=ResourceBundle.getBundle(baseName,locale);
    }
    public void setLocale(Locale locale){
        this.locale=locale;
        resourceBundle=ResourceBundle.getBundle(baseName,locale);

    }
    public String get(String key){
    return resourceBundle.getString(key);
    }
}
