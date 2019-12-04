package by.it.zabauniuk.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String[] sentences = Poem.text.replace("...", "@").split("[.?!]");
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].
                    trim().replaceAll("[^@а-яёА-ЯЁ]+", " ").
                    replace("@", "");
        }
        compareSentences(sentences);
    }


    private static void compareSentences(String[] sentences) {
        boolean isSorted = false;
        String temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < sentences.length - 1; i++) {
                if (sentences[i].length() > sentences[i + 1].length()) {
                    isSorted = false;
                    temp = sentences[i];
                    sentences[i] = sentences[i + 1];
                    sentences[i + 1] = temp;
                }
            }
        }
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
