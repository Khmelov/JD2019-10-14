package by.it.volchek.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> allWords = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        Pattern pattern = compile("[\\w^']");

        for (; ; ) {
            String word = sc.next();
            if (word.equals("end")) break;
            word = word.replaceAll("'{1}", "lalalala")
                    .replaceAll("[\\W]", "")
                    .replaceAll("lalalala", "'")
                    .trim();
            if (!allWords.containsKey(word)) {
                allWords.put(word, 1);
            } else
                allWords.replace(word, allWords.get(word) + 1);
        }
        System.out.println(allWords);
    }
}
