package by.it.protsko.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TaskB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> words = new HashMap<>();

        for (; ; ) {
            String line = sc.next().replaceAll("[,.—:;!)(]+", "");
            if (line.equals("end")) {
                break;
            } else {
                words.put(line, words.get(line) == null ? 1 : words.get(line) + 1);
            }
        }
        System.out.println(words);
    }
}