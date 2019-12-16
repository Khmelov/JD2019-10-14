package by.it.yurtsevich.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Scanner scanner = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = scanner.nextLine()).toLowerCase().equals("end")) {
            if (line.equals("prnt")) {
                Var.printVar();
                continue;
            }
            Var result = parser.calculate(line);
            printer.print(result);
        }
    }
}
