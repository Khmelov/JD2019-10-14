package by.it.zabauniuk.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static int countWords = 0;
    private static int countPunctuation = 0;
    private static Pattern patternWords = Pattern.compile("[а-яА-яёЁ]+");
    private static Pattern patternPunctuation = Pattern.compile("[-,.:!]+");

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }


    public static void main(String[] args) {
        System.out.println(dir(TaskB.class));

        try (BufferedReader br = new BufferedReader(
                new FileReader(dir(TaskA.class) + "text.txt"));
             PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskA.class) + "resultTaskB.txt"))
        ) {
            while (br.ready()) {
                String buf = br.readLine();
                System.out.println(buf);
                Matcher matcher = patternWords.matcher(buf);
                while (matcher.find()) {
                    countWords++;
                }
                Matcher matcher1 = patternPunctuation.matcher(buf);
                while (matcher1.find()) {
                    countPunctuation++;
                }
            }
            System.out.println("words=" + countWords + ", punctuation marks=" + countPunctuation);
            out2.println("words=" + countWords + ", punctuation marks=" + countPunctuation);
        } catch (IOException ignored) {
        }
    }
}
