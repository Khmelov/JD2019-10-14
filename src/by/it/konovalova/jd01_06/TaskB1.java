package by.it.konovalova.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            String word = matcher.group();
            getWord(word);
        }
    }

    private static void getWord(String word) {
        char res1 = word.charAt(0);
        char res2 = word.charAt(word.length() - 1);
        if ((res2 == 'а' || res2 == 'е' || res2 == 'ё' || res2 == 'и' || res2 == 'о' || res2 == 'у' || res2 == 'ы' || res2 == 'э'
                || res2 == 'ю' || res2 == 'я') &&
                (res1 != 'а' || res1 != 'е' || res1 != 'ё' || res1 != 'и' || res1 != 'о' || res1 != 'у' || res1 != 'ы' ||
                        res1 != 'э' || res1 != 'ю' || res1 != 'я') &&
                res1 != 'И') {
            System.out.println(word);
        }
    }
}




















