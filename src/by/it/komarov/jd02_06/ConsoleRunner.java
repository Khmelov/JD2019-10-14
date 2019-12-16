package by.it.komarov.jd02_06;

import java.time.LocalTime;
import java.util.Scanner;


public class ConsoleRunner {
    public static void main(String[] args) throws CalcException{

        Logger.get().log("Hi!");
        Logger.get().log("By!");
        System.out.println(LocalTime.now().toString());

        Scanner scanner = new Scanner(System.in);
        String line;

         Parser parser = new Parser(); // передаем вычисления
         Printer printer = new Printer(); // выводит результат

        while(!(line = scanner.nextLine()).equals("end")){
            Var result = parser.calc(line);
            printer.print(result);
        }
    }
}
