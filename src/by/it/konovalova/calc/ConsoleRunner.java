package by.it.konovalova.calc;


import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
          Var.load();
         for (; ; ) {
            String expression = sc.nextLine();
            Var.save();
            if (expression.equals("end"))
                break;
            try {
                Var result = parser.evaluate(expression);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
