package by.it.yaroshenko.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static Map<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        while (!((s=scanner.next()).equals("end"))) {
            StringBuilder sb = new StringBuilder(s);
            Pattern pattern = Pattern.compile("[\\w']+");
            Matcher matcher = pattern.matcher(sb);
            while (matcher.find()) {
                String word = matcher.group();
                count(word);
            }
        }
          print(hashMap);
    }

        public static void count (String word) {
            Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
            int hashCode = word.hashCode();
            for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getKey().hashCode()==hashCode) {
                Integer integer = entry.getValue();
                integer++;
                entry.setValue(integer);
                return;
            }
            }
            hashMap.put(word, 1);
        }

        public static void print(Map<String, Integer> hashMap) {
            Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                System.out.println(entry.getKey()+"="+entry.getValue());
            }
        }

}
