package by.it.volchek.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            if (checking(matcher.group())) {
                System.out.println(matcher.group());
            }
        }
    }

    private static final char[] vowels = {'А', 'О', 'И', 'Е', 'Ё', 'Э', 'Ы', 'У', 'Ю', 'Я','а', 'о', 'и', 'е', 'ё', 'э', 'ы', 'у', 'ю', 'я'};
    private static boolean checking(String word) {
        char[] words = word.toCharArray();
        for (char vowel : vowels) {
            if (vowel==words[0]) {
                return false;
            }
        }
        for (char vowel : vowels) {
            if (vowel==words[words.length-1])
                return true;
        }
        return false;
    }
}
