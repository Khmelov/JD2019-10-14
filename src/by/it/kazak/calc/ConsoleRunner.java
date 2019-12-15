package by.it.kazak.calc;


import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        try {
            Var.load();
        } catch (Exception e) {
            System.out.println("Невозможно загрузить данные");
        }
        Parser parser = new Parser();
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String expression = scanner.nextLine().replace(" ", "");
            if (expression.equals("end")) break;
            Var result = null;
            try {
                result = parser.evaluate(expression);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
            printer.print(result);
            Logger.get().log((expression+"="+result));
            if (expression.equals("printvar")) {
                printer.print((Var) Var.getVars());
            }
        }
    }
}

