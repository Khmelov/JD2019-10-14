package by.it.protsko.jd02_05;

import java.util.Locale;

class Runner {
    public static void main(String[] args) {
        ResurceManager resurceManager = ResurceManager.INSTANCE;
        Locale locale;

        while ((locale = LanguageChanger.newLanguage()) != null) {
            if (locale == null) {
                break;
            } else {
                resurceManager.setLocale(locale);
                System.out.println(resurceManager.geText(Messages.WELCOME));
                System.out.println(resurceManager.geText(Messages.QUESTION));
                System.out.printf("%s %s\n", resurceManager.geText(Users.FIRSTNAME), resurceManager.geText(Users.LASTNAME));
                System.out.printf("%s %s\n", resurceManager.geText(Date.CURRENTDATE), resurceManager.getDate());
            }
        }
    }
}
