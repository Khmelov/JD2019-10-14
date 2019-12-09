package by.it.konovalova.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int pos = 0;
        for (;;){
            String str=sc.next();
            if(str.equals("end")){
                break;
            }
            Integer value = Integer.valueOf(str);
            if (value < 0) {
                arr.add(value);
            } else if (value == 0) {
                arr.add(pos, value);
            } else
                arr.add(pos++,value);
        }
        System.out.println(arr);
    }
}
