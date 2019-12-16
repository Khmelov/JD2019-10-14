package by.it.komarov.jd02_05;

import java.util.Locale;

public class Runner {

    public static void main(String[] args) {
        ResMan lang = ResMan.INSTANCE;
        if (args.length == 2){
            lang.setLocale(new Locale(args[0],args[1]));
        }
        else
            lang.setLocale(Locale.ENGLISH);

        lang.setLocale(new Locale("ru", "RU"));
        System.out.println(lang.get(Messages.WELCOME));
        System.out.println(lang.get(Messages.QUESTION));
        System.out.printf("%s %s\n",
                lang.get(User.FIRST_NAME),
                lang.get(User.LAST_NAME)
        );
    }
}
