package by.it.zabauniuk.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class Runner {

    public static void main(String[] args) {

        ResMan resMan = ResMan.INSTANCE;
        Scanner scanner = new Scanner(System.in);
        System.out.println("please, choose language:\n" +
                "en-English\n" +
                "be-беларуский\n" +
                "ru-русский");

        while (true) {
            String language = "";
            String country = "";
            String line = scanner.nextLine();
            switch (line) {
                case "en":
                    language = "en";
                    country = "US";
                    break;
                case "be":
                    language = "be";
                    country = "BY";
                    break;
                case "ru":
                    language = "ru";
                    country = "RU";
                    break;
                default:
                    language = "en";
                    country = "US";
                    break;

            }

            Locale locale = new Locale(language, country);
            resMan.setLocale(locale);
            Date date = new Date();
            DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
            String format = df.format(date);
            System.out.println(format);
            System.out.printf("%s\n%s\n%s %s\n",
                    resMan.get(Message.WELCOME),
                    resMan.get(Message.QUESTION),
                    resMan.get(User.FIRST_NAME),
                    resMan.get(User.LAST_NAME)
            );
        }
    }
}