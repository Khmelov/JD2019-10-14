package by.it.yaroshenko.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String s;
        int pos=0;
        while (!((s=scanner.next()).equals("end"))) {
            int i = Integer.parseInt(s);
            //Integer i=Integer.valueOf(s);
            if(i>0){
                arrayList.add(pos++, i);
            }
            if(i==0) {
                arrayList.add(pos,0);
            }
            if (i<0) {
                arrayList.add(i);
            }
        }
        System.out.println(arrayList);
    }
}
