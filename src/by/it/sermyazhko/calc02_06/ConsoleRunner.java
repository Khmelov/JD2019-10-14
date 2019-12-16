package by.it.sermyazhko.calc02_06;

import java.util.Locale;
import java.util.Scanner;

class ConsoleRunner {

    public static void main(String[] args) {
        Scanner sc;
        ResMan lang= ResMan.INSTANCE;
        String country = "";
        String lan = "";
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
            if (str.equals("ru") || str.equals("en") || str.equals("be")) {
                switch (str){
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
                continue;
            }

            try {
                printer.print(parser.calc(str));
            }catch (CalcException e) {
                //System.out.println(e.getMessage());
                //Logger.get().log(e.getMessage());
            }
            if(str.equals("printvar")){
                Var.printMap();
            }
        }
    }
}

