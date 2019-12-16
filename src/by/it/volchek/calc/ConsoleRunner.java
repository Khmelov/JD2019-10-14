package by.it.volchek.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static ResMan lang = ResMan.INSTANCE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        Parser parser = new Parser();

        if (args.length == 2) {
            lang.setLocale(new Locale(args[0], args[1]));
        } else
            lang.setLocale(Locale.ENGLISH);
        Var.load();

        for (; ; ) {
            String expression = scanner.nextLine();

            if (expression.equals("end")) {
                Var.save();
                break;
            }
            switch (expression) {
                case "en":
                    lang.setLocale(new Locale("en", "US"));
                    break;
                case "ru":
                    lang.setLocale(new Locale("ru", "RU"));
                    break;
                case "be":
                    lang.setLocale(new Locale("be", "BY"));
                    break;
                default:
                    Var result = null;
                    try {
                        result = parser.evaluate(expression);
                        printer.print(result);
                    } catch (CalcException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}
