package by.it.komarov.jd01_06;

public class TaskC2 {

    public static void main(String[] args) {

        String poem = Poem.text;
        long startTimeSlow = System.nanoTime();
        String stringLine = slow(poem);
        System.out.println("Время работы метода slow =" +(System.nanoTime() - startTimeSlow));
        long startTimeFast = System.nanoTime();
        String stringBuilderLine = fast(poem);
        System.out.println("Время работы метода fast =" +(System.nanoTime() - startTimeFast));
        }

    private static String slow (String text) {
        String textLine = "";
        String[] wordsArray = text.
                replaceAll("[:,.!-]", "").
                replaceAll("[\\s]{2,}", " ").
                replaceAll("\n", " ").
                split(" ");
        do {
            for (String element : wordsArray) {
                textLine = textLine.concat(element).concat(" ");
                if (textLine.length() > 100000) {
                    break;
                }
            }
        } while (textLine.length() < 100000);
        return textLine;
    }

    private static String fast(String text) {
        StringBuilder sbLine = new StringBuilder();
        String[] wordsArray = text.
                replaceAll("[:,.!-]", "").
                replaceAll("[\\s]{2,}", " ").
                replaceAll("\n", " ").
                split(" ");
        do {
            for (String element : wordsArray) {
                sbLine.append(element).append(' ');
                if (sbLine.length() > 100000) {
                    break;
                }
            }
        } while (sbLine.length() < 100000);
        return sbLine.toString();
    }
}

