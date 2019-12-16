package by.it.baranovskaya.jd01_06;

public class TaskC2 {
    public static void main(String[] args) {
        String text = randomGenerateText(Poem.text);

        System.out.println(slow(text));
        System.out.println(System.nanoTime());

        System.out.println(fast(text));
        System.out.println(System.nanoTime());
    }

    private static String slow(String text) {
        String[] words = text.split("[ ]+");
        String slowString = "";
        do {
            for (String word : words) {
                slowString = slowString.concat(word).concat(" ");
            }
        } while (slowString.length()<100000);

        return slowString;
    }

    private static String fast(String text) {
        String[] words = text.split("[ ]+");
        StringBuilder fastString = new StringBuilder();
        do {
            for (String word : words) {
                fastString.append(word).append(" ");
            }
        } while (fastString.length()<100000);

        return String.valueOf(fastString);
    }

    private static String randomGenerateText(String Ptext) {
        String[] words = Ptext.split("[ ,-.:!\\n]+");
        StringBuilder randomText = new StringBuilder();
        do {
            for (int i = 0; i < words.length; i++) {
                int rword = (int) (Math.random() * 146);
                randomText.append(words[rword]).append(" ");
            }
        } while (randomText.length()<100000);

        return String.valueOf(randomText);
    }
}
