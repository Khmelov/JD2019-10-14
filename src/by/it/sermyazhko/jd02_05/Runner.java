package by.it.sermyazhko.jd02_05;


import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner sc = new Scanner("Write your language: ");
        String language = sc.next();
        ResMan lang= ResMan.INSTANCE;
        if (args.length==2){
            lang.setLocale(new Locale(args[0],args[1]));
        }
        else
            lang.setLocale(new Locale("en","US"));

        System.out.println(lang.get(Messages.WELCOME));
        System.out.println(lang.get(Messages.QUESTION));
        System.out.printf("%s %s\n",
                lang.get(User.FIRST_NAME),
                lang.get(User.LAST_NAME)
        );
    }

}
