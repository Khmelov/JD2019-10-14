package by.it.sermyazhko.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

class TaskA3 {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int posZero=0;
        for(;;){
            String word = scanner.next();
            if (word.equals("end")){
                break;
            }
            Integer i = Integer.valueOf(word);
            if (i<0)
                numbers.add(i);
            else if (i==0)
                numbers.add(posZero,i);
            else
                numbers.add(posZero++,i);
        }
        System.out.println(numbers);
    }
}
