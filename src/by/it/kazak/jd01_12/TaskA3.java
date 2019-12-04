package by.it.kazak.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int zeroPos = 0;
        for (;;) {
            String word = sc.next();
            if (word.equals("end")){
                break;
            }
            Integer i = Integer.valueOf(word);
            if (i<0)
                numbers.add(i);
            else if (i==0)
                numbers.add(zeroPos,i);
            else
                numbers.add(zeroPos++,i);
        }
        System.out.println(numbers);
    }
}
