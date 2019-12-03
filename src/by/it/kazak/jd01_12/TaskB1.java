package by.it.kazak.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static Map<String,Integer> map = new HashMap<>(16*3);

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true){
            String next = scanner.next();
            if(next.equals("end"))break;
            sb.append(next);
            sb.append(" ");
        }
        TaskB1.process(sb);
    }

    private static void process(StringBuilder sb) {
        Pattern pattern = Pattern.compile("[a-zA-Z']+");
        Matcher matcher = pattern.matcher(sb);
        int i = 1;
        while (matcher.find()){
            String word = matcher.group();
            if(word.equals("isn't")||word.equals("don't"))
                map.put("don't",i++);
            else {
                if (map.containsKey(word)) {
                    Integer integer = map.get(word);
                    map.put(word, integer + 1);
                } else map.put(word, 1);
            }
        }
        printMap(map);
    }

    private static void printMap(Map<String, Integer> map) {
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}