package by.it.toporova.jd01_09;

import by.it.konovalova.jd01_09.Printer;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//ввод с консоли
        Parser parser = new Parser();
        String line;
        Printer09 printer = new Printer09();
        while (!(line=scanner.
                nextLine()).
                equals("end")){
            Var result=parser.calc(line.trim());
            printer.print(result);
        }





    }
}