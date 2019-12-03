package by.it.toporova.calc;

import java.util.Scanner;

//Скопируйте ваш калькулятор в пакет by.it.фамилия.calc, в список операций добавьте пятую -присваивание:
//TaskА Переменная=значение(Для хранения рекомендуется HashMap или аналог).
//TaskBКоманда консоли printvar построчно показывает список переменныхв формате A=3или B={1, 2, 3} или C={{1, 2}, {3, 4}} (порядок произвольный)
//TaskCВвод в консоль sortvarвыводит список имен и значений переменных (имя переменной при этом сортируется по алфавитуметодами коллекций).

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//ввод с консоли
        Parser parser = new Parser();
        String line;
        Printer printer = new Printer();
        while (!(line = scanner.
                nextLine()).
                equals("end")) {
            Var result = null;
            try {
                result = parser.calc(line.trim());
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
            printer.print(result);
        }
        if (scanner.equals("printvar")) {
            Var.printMap();
        }
        if (scanner.equals("sortvar")){
            Var.printMap();
        }


    }
}