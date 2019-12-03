package by.it.kharitonenko.jd01_13;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//        Нужно написать в TaskC программу, которая будет вводить вещественные числа с
//        консоли, после каждой ошибки программа делает паузу в 100 мс и выводит накопленные числа в
//        обратном порядке.
//         Используйте Scanner, но он должен создаваться только один раз и обязательно в методе main.
//         Код по чтению чисел с клавиатуры должен быть в методе static void readData().
//         Если пользователь ввёл какой-то текст, вместо ввода числа, то метод readData() должен перехватить
//        исключение, сделать паузу Thread.sleep(100) и вывести на экран все ранее введенные числа.
//         Числа нужно выводить без форматирования, через пробел, в порядке обратном вводу.
//         После 5 допущенных ошибок программа должна завершиться, пробрасывая ошибку в JVM.
public class TaskC {
    static Scanner scanner;
    static Deque<String> enteredNumbers = new LinkedList<>();
    static int numberOfErrors = 0;

    static void readData() throws InterruptedException {

        String enteredText = scanner.next();

        try {
            if (!enteredText.matches("[\\d.]")) {
                TaskC.numberOfErrors+=1;
                    if (numberOfErrors > 5) throw new RuntimeException("error too many errors");
                throw new WrongDataEnteredException();
            }
            else {
                enteredNumbers.add(enteredText);
            }
        } catch (WrongDataEnteredException e) {
            Thread.sleep(100);
            for (int i = 0; i < enteredNumbers.size(); i++) {
                System.out.print(Double.valueOf(enteredNumbers.getLast()) + " ");
                enteredNumbers.addFirst(enteredNumbers.removeLast());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        for (; ; ) {
            readData();
        }
    }
}

class WrongDataEnteredException extends Throwable {
    public WrongDataEnteredException() {
//        TaskC.numberOfErrors += 1;
        System.out.println("error = wrong data entered");
    }

    public WrongDataEnteredException(String message) {
        super(message);
    }

    public WrongDataEnteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongDataEnteredException(Throwable cause) {
        super(cause);
    }
}