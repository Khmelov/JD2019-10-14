package by.it.toporova.jd02_05;


import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ResMan lang = ResMan.INSTANCE;
        for(;;) {
            String setLang = sc.nextLine();
            if (setLang.equals("ru")) {
                lang.setLocale(new Locale("ru", "RU"));
                printToConsole(lang);
            } else if (setLang.equals("be")) {
                lang.setLocale(new Locale("be", "BY"));
                printToConsole(lang);
            } else if (setLang.equals("en")) {
                lang.setLocale(new Locale("en", "EN"));
                printToConsole(lang);
            } else if(setLang.equals("end")){
                break;
            }
            else {
                System.out.println("No such language");
            }
        }
    }
    static void printToConsole(ResMan lang){
        System.out.println(lang.get(Messages.WELCOME));
        System.out.printf("%s %s\n", lang.get(User.FIRST_NAME), lang.get(User.LAST_NAME));
        lang.getLocalDate();
    }
}