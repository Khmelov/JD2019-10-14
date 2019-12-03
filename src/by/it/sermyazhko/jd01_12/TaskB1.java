package by.it.sermyazhko.jd01_12;

import by.it.sermyazhko.jd01_04.TaskC;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class TaskB1 {

    Map<String,Integer> words = new HashMap<>();
    Scanner scan = new Scanner(System.in);

    static void print(Map<String,Integer> words) {
        for (Map.Entry<String,Integer> elem : words.entrySet()) {
            System.out.println(elem.getKey() + "=" + elem.getValue());
        }
    }

    static void insert(Map<String,Integer> words, String s){
        boolean flag = false;
        Iterator<Map.Entry<String, Integer>> iterator = words.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            if(next.getKey().equals(s)){
                next.setValue(next.getValue()+1);
                flag = true;
                break;
            }
        }
        if(!flag)
        words.put(s,1);
    }

    public static void main(String[] args) {
        TaskB1 task = new TaskB1();
        Pattern p = Pattern.compile("[a-zA-Z']+");

       for (;;){
           boolean flag = true;
            String s = task.scan.nextLine();
            Matcher m = p.matcher(s);
            while (m.find()){
                if(m.group().equals("end")){
                    flag = false;
                    break;
                }
                else{
                    insert(task.words, m.group());
                }
            }
            if(!flag) break;
        }
        print(task.words);
    }
}
