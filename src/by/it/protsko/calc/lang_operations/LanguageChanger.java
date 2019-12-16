package by.it.protsko.calc.lang_operations;

import java.util.Locale;

public class LanguageChanger {

    private static Locale locale;

    private static Locale changeLanguage(String lang) {
        switch (lang) {
            case "ru":
                locale = new Locale("ru", "RU");
                return locale;
            case "be":
                locale = new Locale("be", "BY");
                return locale;
            case "en":
                locale = new Locale("en", "EN");
                return locale;
            default:
                Locale.getDefault();
        }
        return locale;
    }

    public static Locale newLanguage(String lang) {
        return locale = changeLanguage(lang);
    }
}
