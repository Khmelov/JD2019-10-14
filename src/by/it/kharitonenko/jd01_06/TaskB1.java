package by.it.kharitonenko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    //все гласные символы
    private static final char[] vowels = {'а', 'о', 'и', 'е', 'ё', 'э', 'ы', 'у', 'ю', 'я', 'А', 'О', 'И', 'Е', 'Ё', 'Э', 'Ы', 'У', 'Ю', 'Я'};

    //проверка слова, сначала проверяется первая буква, затем последняя
    private static boolean checkChars(String word) {
        char[] checkWord = word.toCharArray();
        for (char vowel : vowels) {
            if (vowel==checkWord[0]) {
                return false;
            }
        }
        for (char vowel : vowels) {
            if (vowel==checkWord[checkWord.length-1])
                return true; //слово прошло обе проверки
        }
        return false;
    }


    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            if (checkChars(matcher.group())) {
                System.out.println(matcher.group());
            }
        }
    }
}
