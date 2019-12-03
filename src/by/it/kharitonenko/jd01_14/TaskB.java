package by.it.kharitonenko.jd01_14;

//           В файле с текстом TaskB.txt нужно подсчитать общее количество знаков
//        препинания и слов
//           Вывести результат на консоль в виде одной строки:
//        words=123, punctuation marks=15
//           Продублировать вывод в консоль в файл resultTaskB.txt

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static String convertFileToString(BufferedReader textFile) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        textFile.mark(1000);
        while (textFile.ready()) {
            stringBuilder.append((char)textFile.read());
        }
        textFile.reset();
        return stringBuilder.toString();
    }

    private static String dir(Class<?> cl) {
        return System.getProperty("user.dir") + File.separator + ("src") +
                File.separator + cl.getName().
                replace(cl.getSimpleName(), "").
                replace(".", File.separator);
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        try (BufferedReader reader = new BufferedReader(new FileReader(dir(TaskB.class) + "text.txt"));
             PrintWriter output = new PrintWriter
                     (new FileWriter(dir(TaskA.class) + "resultTaskB.txt"))
        ) {

            Matcher matcher = pattern.matcher(convertFileToString(reader));
            //words
            int words = 0;
            while (matcher.find()) {
                words += 1;
            }
            //not words
            pattern = Pattern.compile("[,\\\\.:!]");
            matcher.reset();
            matcher = pattern.matcher(convertFileToString(reader));
            int notWords = 0;
            while (matcher.find()) {
                notWords += 1;
            }
            System.out.println("words=" + words + ", punctuation marks=" + notWords);
            output.println("words=" + words + ", punctuation marks=" + notWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}