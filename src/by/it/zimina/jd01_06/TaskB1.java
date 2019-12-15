package by.it.zimina.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static String[] words = new String[0];
    private  static char[] vowels = {'а','о','и','е','ё','э','ы','у','ю','я'};

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String word = matcher.group();
            fillWord(word);
        }

        getWord(words);
    }

    private static boolean isVowels(char c){
        c= Character.toLowerCase(c);
        for(char d : vowels) {
            if(c == d) {
                return true;
            }
        }
        return false;
    }

    private static void fillWord(String word) {
        words = Arrays.copyOf(words, words.length+1);
        words [words.length-1] = word;
    }

    private static void getWord(String[] words){
        for (String word : words) {
            char f = word.charAt(0);
            char l = word.charAt(word.length() - 1);
            if (!isVowels(f)) {
                if (isVowels(l)) {
                    System.out.println(word);
                }
            }
        }
    }


}
