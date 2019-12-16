package by.it.yaroshenko.jd02_05;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResMan lang = ResMan.INSTANCE;
        getText(args, lang);
        setLocal();
    }

    private static void setLocal() {
        Scanner scanner = new Scanner(System.in);
        String enterText = scanner.nextLine();
        DateFormat dfBy = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("by", "BY"));
        DateFormat dfRu = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("ru", "RU"));
        DateFormat dfEn = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("en", "EN"));
        Locale local;

        switch (enterText) {
            case "by":
                String localBy = dfBy.format(new Date());
                System.out.println(localBy);
                break;
            case "ru":
                String localRu = dfRu.format(new Date());
                System.out.println(localRu);
                break;
            case "en":
                String localEn = dfEn.format(new Date());
                System.out.println(localEn);
                break;
            default:
                System.out.println("Enter correct command");
                break;
        }
    }


    private static void getText(String[] args, ResMan lang) {
        if(args.length==2){
            lang.setLocal(new Locale(args[0], args[1]));
        }
        else lang.setLocal(Locale.ENGLISH);
        System.out.println(lang.get(Messages.WELCOME));
        System.out.println(lang.get(Messages.QUESTION));
        System.out.printf("%s %s\n",lang.get(User.FIRST_NAME),lang.get(User.LAST_NAME));
    }
}
