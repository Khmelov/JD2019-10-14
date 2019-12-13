package by.it.yurtsevich.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int posZero=0;
        for(;;){
            String word = sc.next();
            if (word.equals("end")){
                break;
            }
            Integer i = Integer.valueOf(word);
            if (i<0)
                arr.add(i);
            else if (i==0)
                arr.add(posZero,i);
            else
                arr.add(posZero++,i);
        }
        System.out.println(arr);
    }
}
