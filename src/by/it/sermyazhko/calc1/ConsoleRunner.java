package by.it.sermyazhko.calc1;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

class ConsoleRunner {
    /*private static void print(Var var) {
        if (var!=null)
            System.out.println(var);
    }*/

    public static void main(String[] args) {
        Scanner sc;
        ResMan lang= ResMan.INSTANCE;
        //если с параметрами,то язык берется из параметров
        if (args.length==2){
            lang.setLocale(new Locale(args[0],args[1]));
        }
        //предлагаем иначе выбрать язык, по умолчанию английский
        else{
            System.out.println("Write your language : en, ru, be");
            sc = new Scanner(System.in);
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

       // System.out.print(lang.get(CurrentData.DATA) + ": ");
       // Format formatter = new SimpleDateFormat(lang.get(CurrentData.FORMAT_FULL),lang.getLocale());
      //  String s = formatter.format(new Date());
      //  System.out.println(s);
       // System.out.println(lang.get(Messages.WELCOME));
       // System.out.println(lang.get(Messages.QUESTION));
       /* System.out.printf("%s %s\n",
                lang.get(Errors.FIRST_NAME),
                lang.get(Errors.LAST_NAME)
        );*/
        System.out.println("The calculator is ready to go:");
        sc = new Scanner(System.in);
        Printer printer = new Printer();
        Parser parser = new Parser();
        Var.load();
        for(;;){
            String str = sc.nextLine();
            if (str.equals("end")) {
                Var.save();
                break;
            }
            //System.out.println(parser.calc(str));
            try {
                //Var result = parser.calc(str);//{{1,2},{8,3},{1,8}}*{{1,2},{8,3}}
                printer.print(parser.calc(str));
            }catch (CalcException e) {
                System.out.println(e.getMessage());
            }
            if(str.equals("printvar")){
                Var.printMap();
            }
        }

    }
}

