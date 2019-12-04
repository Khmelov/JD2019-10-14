package by.it.zimina.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String line;

        Parser parser=new Parser();
        Printer printer=new Printer();

        while (!(line=scan.nextLine()).equals("End")) {
            Var result=parser.calc(line);
            printer.print(result);
        }
    }
}
