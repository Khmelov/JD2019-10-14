package by.it.volchek.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {
        String words = Poem.text.replaceAll("[^а-яА-ЯёЁ.!]+", " ")
        .replaceAll("[.]{2,}", "");
        String [] sentences = words.split("[.!]");
        for (int i = 0; i < sentences.length; i++) {
            for (int j = i + 1; j < sentences.length; j++) {
                if (sentences[i].length() > sentences[j].length()) {
                    String s = sentences[i].trim();
                    sentences[i] = sentences[j].trim();
                    sentences[j] = s;
                }
            }
        }
        for (String result : sentences) {
            System.out.println(result);
        }
    }
}
