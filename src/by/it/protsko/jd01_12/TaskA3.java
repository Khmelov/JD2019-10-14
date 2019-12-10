package by.it.protsko.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int positionZero = 0;
        Scanner sc = new Scanner(System.in);

        for (; ; ) {
            String word = sc.nextLine();
            if (word.equals("end")) {
                break;
            } else {
                Integer number = Integer.valueOf(word);
                if (number < 0) list.add(number);
                if (number == 0) list.add(positionZero, number);
                if (number > 0) list.add(positionZero++, number);
            }
        }
        System.out.println(list);
    }
}