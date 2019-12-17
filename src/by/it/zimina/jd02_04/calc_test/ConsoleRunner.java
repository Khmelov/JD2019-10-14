package by.it.zimina.jd02_04.calc_test;



import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = scanner.nextLine()).equals("end")) {
            try {
                Var res = parser.calc(line);
                printer.print(res);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}