package by.it.sermyazhko.jd02_05;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

class Runner {

    public static void main(String[] args) {


        //на TaskA
        /*
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
         */
        //На TaskA + TaskB совмещена
        ResMan lang= ResMan.INSTANCE;
        //если с параметрами,то язык берется из параметров
        if (args.length==2){
            lang.setLocale(new Locale(args[0],args[1]));
        }
       //предлагаем иначе выбрать язык, по умолчанию английский
       else{
            System.out.println("Write your language : en, ru, be");
            Scanner sc = new Scanner(System.in);
            String language = sc.next();
            String country = "";
            String lan = "";
            switch (language){
                case "ru":
                    country = "RU";
                    lan = "ru";
                    break;
                case "be":
                    country = "BY";
                    lan = "be";
                    break;
                default:
                    country = "US";
                    lan = "en";
            }

            lang.setLocale(new Locale(lan,country));
        }

        System.out.print(lang.get(CurrentData.DATA) + ": ");
        Format formatter = new SimpleDateFormat(lang.get(CurrentData.FORMAT_FULL),lang.getLocale());
        String s = formatter.format(new Date());
        System.out.println(s);
        System.out.println(lang.get(Messages.WELCOME));
        System.out.println(lang.get(Messages.QUESTION));
        System.out.printf("%s %s\n",
                lang.get(User.FIRST_NAME),
                lang.get(User.LAST_NAME)
        );


    }

}
