package by.it.zimina.jd01_06;

import java.util.regex.Pattern;

public class TaskB2 {

    public static void main(String[] args) {
        String delLong = Poem.text.replace("...","   ");
        String[] sentences = delLong.split("[.!]+");
        replace(sentences);
        sort(sentences);
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }

    private static void replace(String[] sentences) {
        for (int i = 0; i <sentences.length ; i++) {
            sentences[i] = sentences[i].replace(",\n", " ");
            sentences[i] = sentences[i].replace("\n", " ");
            sentences[i] = sentences[i].replace(", ", " ");
            sentences[i] = sentences[i].replace(" - "," ");
            sentences[i] = sentences[i].replace(": ", " ");
            sentences[i] = sentences[i].trim();
        }
    }

    private static void sort(String[] sentences) {
        boolean swap;
        int last = sentences.length-1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if(sentences[i].length()>sentences[i+1].length()) {
                    String copy = sentences[i];
                    sentences[i] = sentences[i+1];
                    sentences[i+1] = copy;
                    swap = true;
                }
            }
            last--;
        } while (swap);
    }

}
