package by.it.kharitonenko.calc;

import by.it.kharitonenko.calc.Vars.*;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static ResManager lang = ResManager.INSTANCE;

    static {
        lang.setLocale(Locale.getDefault());
    }

    public ResManager getLang() {
        return lang;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        Parser parser = new Parser();
        Var.load();
        for (; ; ) {
            String expression = scanner.nextLine();
            if (expression.equalsIgnoreCase("end")) {
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
                    Var result;
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
