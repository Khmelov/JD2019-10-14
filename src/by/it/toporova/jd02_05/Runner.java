package by.it.toporova.jd02_05;


import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ResMan lang = ResMan.INSTANCE;
        label:
        for(;;) {
            String setLang = sc.nextLine();
            switch (setLang) {
                case "ru":
                    lang.setLocale(new Locale("ru", "RU"));
                    printToConsole(lang);
                    break;
                case "be":
                    lang.setLocale(new Locale("be", "BY"));
                    printToConsole(lang);
                    break;
                case "en":
                    lang.setLocale(new Locale("en", "US"));
                    printToConsole(lang);
                    break;
                case "end":
                    break label;
                default:
                    System.out.println("No such language");
                    break;
            }
        }
    }
    private static void printToConsole(ResMan lang){
        System.out.println(lang.get(Messages.WELCOME));
        System.out.println(lang.get(Messages.QUESTION));
        System.out.printf("%s %s\n", lang.get(User.FIRST_NAME), lang.get(User.LAST_NAME));
        lang.getLocalDate();

    }
}