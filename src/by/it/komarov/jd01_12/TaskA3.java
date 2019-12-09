package by.it.komarov.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int posZero = 0;
        while (true) {
            String word = scanner.next();
            if (word.equals("end")) {
                break;
            }
            Integer value = Integer.valueOf(word);
            if (value < 0)
                numbers.add(value);
            else if (value == 0)
                numbers.add(posZero, value);
            else
                numbers.add(posZero++, value);
        }
        System.out.println(numbers);
    }
}


