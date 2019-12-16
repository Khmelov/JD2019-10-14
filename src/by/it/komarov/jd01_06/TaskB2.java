package by.it.komarov.jd01_06;

public class TaskB2 {

    public static void main(String[] args) {
        String text = Poem.text.replace("...", "\\").replaceAll("[^а-яёА-ЯЁ!?.]", " ").replaceAll("[\\s]{2,}", " ");
        String[] sentences = text.split("[.!?]");

        for (int i = 0; i < sentences.length; i++) {
            for (int j = i + 1; j < sentences.length; j++) {
                if (sentences[i].length() > sentences[j].length()) {
                    String temp = sentences[i].trim();
                    sentences[i] = sentences[j].trim();
                    sentences[j] = temp;
                }
            }
        }
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
