package by.it.toporova.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Нужно написать в TaskC программу, которая будет вводить вещественные числас консоли,
// после каждой ошибки программа делает паузу в 100 мс и выводит накопленные числа в обратном порядке.
//Используйте Scanner, но он должен создаваться только один рази обязательнов методе main.
//Код по чтению чиселс клавиатуры должен быть в методе static void readData().
//Если пользователь ввёл какой-то текст, вместо ввода числа, то метод readData() должен перехватить
// исключение,
// сделать паузу Thread.sleep(100)и вывести на экран все ранее введенные числа.
//Числа нужно выводить без форматирования,через пробел, в порядке обратном вводу.
//После 5 допущенных ошибок программа должна завершиться, пробрасывая ошибку в JVM.
public class TaskC {
    private static int counter = 0;
    private static List<Double> list = new ArrayList<>();
    private static String text;

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        while (counter != 5) {
            text = scanner.nextLine();
            readData();
        }
    }

    static void readData() throws Exception {
        try {
            double number = Double.parseDouble(text);
            list.add(0, number);
        } catch (NumberFormatException e) {
            if (counter == 5) {
                throw new NumberFormatException();

            } else {
                counter++;
                Thread.sleep(100);
                for (Double element : list) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        }


    }
}



