package by.it.protsko.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class LanguageChanger {

    private static Scanner sc;
    private static Locale locale;

    private static Locale changeLanguage() {
        sc = new Scanner(System.in);
        String line = sc.nextLine();
        switch (line) {
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
                locale = null;
        }
        return locale;
    }

    static Locale newLanguage() {
        return locale = changeLanguage();
    }
}
