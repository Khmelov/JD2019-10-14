package by.it.kharitonenko.calc;

import by.it.kharitonenko.calc.Vars.*;

import java.util.Scanner;

public class ConsoleRunner {
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
            Var result = null;
            try {
                result = parser.evaluate(expression);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
