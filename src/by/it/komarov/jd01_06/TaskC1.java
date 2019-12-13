package by.it.komarov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    public static void main(String[] args) {
        String poem = Poem.text;
        System.out.println(formatText(poem));
    }

    private static String formatText(String text) {
        String[] textArray = text.split("\\n");
        Pattern pattern = Pattern.compile(" [-.,а-яёА-ЯЁ:!]");
        Matcher matcher;
        StringBuilder formatText = new StringBuilder();

        int maxSentenceLength = 0;
        for (String sentence : textArray) {
            if (sentence.length() > maxSentenceLength) {
                maxSentenceLength = sentence.length();
            }
        }

        for (String element : textArray) {
            StringBuilder sentence = new StringBuilder(element);
            int needConcatSpace = maxSentenceLength - element.length();

            if (sentence.length() < maxSentenceLength) {
                matcher = pattern.matcher(sentence);
                int pos = 0;
                do {
                    if (matcher.find(pos)) {
                        sentence.insert(matcher.start() + 1, " ");
                        pos = matcher.end() + 1;
                        needConcatSpace--;
                    } else {
                        pos = 0;
                    }
                } while (needConcatSpace != 0);
                formatText.append(sentence).append('\n');
            } else {
                formatText.append(sentence).append('\n');
            }
        }
        return formatText.toString();
    }
}