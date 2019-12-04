package by.it.zabauniuk.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int position = 0;
        for(;;){
            String word = scanner.next();
            if (word.equals("end")){
                break;
            }
            Integer integer = Integer.valueOf(word);
            if (integer<0)
                arrayList.add(integer);
            else if (integer==0)
                arrayList.add(position, integer);
            else
                arrayList.add(position++, integer);
        }
        System.out.println(arrayList);

    }

}


