package by.it.yaroshenko.calc;

import by.it.yaroshenko.jd02_06.Singleton;

import java.util.Scanner;

public class ConsoleRunner extends Var {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();
        Var.load();

        while (!((line = scanner.next()).equals("end"))) {
            Var.save();

            Logger.getInstance().addLogFile(Logger.dataAndTimeLog()+"\t"+line);

            if ((line).equals("printvar")) {
                printer.printHashMap(Var.getMap());
                continue;
            }
            if ((line).equals("sortvar")) {
                printer.printTreeMap(Var.getSortMap());
                continue;
            }
            try {
                Var result = parser.calc(line);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
        Var.save();
    }
}
