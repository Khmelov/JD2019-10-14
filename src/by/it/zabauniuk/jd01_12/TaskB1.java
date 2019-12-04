package by.it.zabauniuk.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static Map<String, Integer> words = new HashMap<>(200);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String text;
        do {
            text = scanner.nextLine();
            sb.append(text).append(' ');
        } while (!text.equals("end"));
        Pattern pattern = Pattern.compile("[a-zA-Z']+");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            String word = matcher.group();
            process(word);
        }
        print(words);
    }
    private static void print(Map<String, Integer> words) {
        Set<Map.Entry<String, Integer>> entries = words.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    private static void process(String word) {
        int code = word.hashCode();

        Set<Map.Entry<String, Integer>> entries = words.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getKey().hashCode() == code) {
                Integer count = entry.getValue();
                count++;
                entry.setValue(count);
                return;
            }
        }
        words.put(word, 1);


    }


}
