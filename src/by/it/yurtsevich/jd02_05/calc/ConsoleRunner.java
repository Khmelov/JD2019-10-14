package by.it.yurtsevich.jd02_05.calc;



import by.it.yurtsevich.jd02_05.ResourceManager;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static ResourceManager resourceManager=ResourceManager.INSTANCE;

    public static void main(String[] args) throws CalcException {
        Scanner scanner = new Scanner(System.in);
        String line;

        if (args.length==2){
            String lang=args[0];
            String country=args[1];
            Locale locale=new Locale(lang,country);
            resourceManager.setLocale(locale);
        }
        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = scanner.nextLine()).toLowerCase().equals("end")) {
            if (line.equals("printvar")) {
                Var.printVar();
                continue;
            }
            if (line.equals("en")) {
                resourceManager.setLocale(new Locale("en", "US"));
                continue;
            }
            if (line.equals("ru")) {
                resourceManager.setLocale(new Locale("ru", "RU"));
                continue;
            }
            if (line.equals("be")) {
                resourceManager.setLocale(new Locale("be", "BY"));
                continue;
            }
            try {
                Var result = parser.calculate(line);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
