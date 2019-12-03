package by.it.konovalova.calc;

import java.util.HashMap;
import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();

        for (; ; ) {
            String expression = sc.nextLine();
            if (expression.equals("end"))
                break;

            try {
                Var result = parser.calc(expression);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
