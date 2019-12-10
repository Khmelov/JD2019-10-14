package by.it.konovalova.jd01_12;

import java.util.*;

public class TaskB1 {

    public static void main(String[] args) {

        Map<String, Integer> text = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            String word = sc.next();
            if (word.equals("end")) {
                break;
            }
            word = word.replaceAll("'{1}", "123").replaceAll("[\\p{Punct}]", "").
                    replaceAll("123", "'").trim();
            if (text.containsKey(word))
                text.replace(word, text.get(word) + 1);
            else text.put(word, 1);
        }
        System.out.println(text);

    }
}
