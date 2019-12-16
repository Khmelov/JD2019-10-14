package by.it.sermyazhko.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    static char[] consonant = {'б', 'в', 'г', 'д', 'ж', 'з', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'й',
            'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'К', 'Л', 'М', 'Н', 'П', 'Р', 'С', 'Т', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Й' };
    static char[] vowels = {'а', 'о', 'э', 'и', 'у', 'ы', 'е', 'ё', 'ю', 'я',
            'A', 'О', 'Э', 'И', 'У', 'Ы', 'Е', 'Ё', 'Ю', 'Я'};

    private static boolean check(String word) {
        for (int i = 0; i < consonant.length; i++) {
            if(word.charAt(0) == consonant[i]){
                for (int j = 0; j < vowels.length; j++) {
                    if(word.charAt(word.length()-1) == vowels[j]){
                        return true;
                    }
                }
             }
        }
        return false;
    }

    public static void main(String[] args) {
        String regex = "[а-яёА-ЯЁ]+";
        Pattern p1 = Pattern.compile(regex);
        Matcher m1 = p1.matcher(Poem.text);
        while(m1.find()) {
            String word = m1.group();
            if(check(word)){
                System.out.println(word);
            }
        }
    }
}
