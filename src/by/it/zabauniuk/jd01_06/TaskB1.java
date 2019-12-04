package by.it.zabauniuk.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB1 {
    private static String[] wordsArr = new String[0];
    private static char[] vowelsArr = {'а', 'е', 'ё', 'э', 'ы', 'у', 'о', 'и', 'ю', 'я'};

    public static void main(String[] args) {
        Pattern p = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = p.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            process(word);
        }
        findWord(wordsArr);
    }

    private static void process(String word) {
        wordsArr = Arrays.copyOf(wordsArr, wordsArr.length+1);
        wordsArr [wordsArr.length-1] = word;
    }

    private static boolean isVowels(char c) {
        c = Character.toLowerCase(c);
        for (char v : vowelsArr) {
            if (c == v) {
                return true;
            }
        }
        return false;
    }

    private static void findWord(String[] words) {
        for (String word : words) {
            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);
            if (!isVowels(first)) {
                if (isVowels(last)) {
                    System.out.println(word);
                }
            }
        }


    }
}
