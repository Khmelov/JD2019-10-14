package by.it.baranovskaya.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pos=0;
        for(;;){
           String str = scanner.next();
            if (str.equals("end")){
                break;
            }
            Integer value = Integer.valueOf(str);
            if (value<0) numbers.add(value);
            else if (value==0) numbers.add(pos,value);
            else numbers.add(pos++,value);
        }
        System.out.println(numbers);
    }
}