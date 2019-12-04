package by.it.zabauniuk.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        String line;
        Printer printer = new Printer();
        while (!(line=scanner.
                nextLine()).
                equals("end")){
            Var result=parser.calc(line.trim());
            printer.print(result);
        }





    }
}