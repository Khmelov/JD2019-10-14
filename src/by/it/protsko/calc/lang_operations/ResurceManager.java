package by.it.protsko.calc.lang_operations;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResurceManager {
    INSTANSE;

    private final String resourceName = "by.it.protsko.calc.lang_operations.lang.translate";
    private Locale locale = Locale.getDefault();
    private static ResourceBundle resourceBundle;

    ResurceManager() {
        setLocal(Locale.getDefault());
//        setLocal(Locale.ENGLISH);
    }

    public void setLocal(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }

    public Locale getCurrentLocale() {
        return resourceBundle.getLocale();
    }

    public String getMessage(String key) {
        return resourceBundle.getString(key);
    }
}
