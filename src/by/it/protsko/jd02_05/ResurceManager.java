package by.it.protsko.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import static java.util.Locale.CANADA;

enum ResurceManager {
    INSTANCE;

    private final String resourceName = "by.it.protsko.jd02_05.lang.translate";
    private ResourceBundle resourceBundle;

    ResurceManager() {
        setLocale(CANADA);
    }

    void setLocale(Locale locale){
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }

    String geText(String key){
        return resourceBundle.getString(key);
    }

    String getDate(){
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, resourceBundle.getLocale());
        return df.format(new Date());
    }
}
