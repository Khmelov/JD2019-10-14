package by.it.konovalova.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB {
    public static void main(String[] args) {
        String path = getPath();
        String fileName = path + "text.txt";
        StringBuilder sb = new StringBuilder();
        readText(fileName, sb);
        printToConsole(counWords(sb), counPunctuation(sb));
        printToFile(path, counWords(sb), counPunctuation(sb));
    }

    private static void readText(String fileName, StringBuilder sb) {
        try (BufferedReader dis = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName)))) {
            String line;
            while (null != (line = dis.readLine())) {
                sb.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int counWords(StringBuilder sb) {
        int sumWords = 0;
        Pattern pattern = Pattern.compile("[А-Яа-яёЁ]+");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            sumWords++;
        }
        return sumWords;
    }


    private static int counPunctuation(StringBuilder sb) {
        int sumPunctuation = 0;
        Pattern pattern = Pattern.compile("[\\p{Punct}]+");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            sumPunctuation++;
        }
        return sumPunctuation;
    }


    private static void printToConsole(int sumWords, int sumPunctuation) {
        System.out.println("words=" + sumWords + ", punctuation marks=" + sumPunctuation);
    }

    private static void printToFile(String path, int sumWords, int sumPunctuation) {
        try (PrintWriter out = new PrintWriter(new FileWriter(path + "resultTaskB.txt"))) {
            out.println("words=" + sumWords + ", punctuation marks=" + sumPunctuation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath() {
        return System.getProperty("user.dir") + File.separator + "src" + File.separator
                + TaskB.class.getName().
                replace(TaskB.class.getSimpleName(), "").
                replace(".", File.separator);
    }
}





