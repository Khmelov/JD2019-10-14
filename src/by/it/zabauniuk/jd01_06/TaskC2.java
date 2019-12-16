package by.it.zabauniuk.jd01_06;

import java.util.Random;

public class TaskC2 {

    public static void main(String[] args) {

        String text = Poem.text;

        long slowStart = System.nanoTime();
        String slowString = slow(text);
        long slowEnd = System.nanoTime();
        System.out.println(slowString);
        System.out.println("Slow time = " + (slowEnd - slowStart));
        long fastStart = System.nanoTime();
        String fastString = fast(text);
        long fastEnd = System.nanoTime();
        System.out.println(fastString);
        System.out.println("Fast time = " + (fastEnd - fastStart));
    }

    private static String slow(String text) {
        String[] words = text.split("[^а-яА-ЯёЁ]+");
        String slowString = "";
        Random rnd = new Random(0);
        while (slowString.length() < 100_000) {
            slowString = slowString + words[rnd.nextInt(words.length-1)] + " ";
        }
        return slowString.trim();
    }

    private static String fast(String text) {
        String[] words = text.split("[^а-яА-ЯёЁ]+");
        StringBuilder sb = new StringBuilder(" ");
        Random rnd = new Random(0);
        while (sb.length() < 100_000) {
            sb.append(words[rnd.nextInt(words.length-1)]).append(" ");
        }
        return sb.toString().trim();
    }
}