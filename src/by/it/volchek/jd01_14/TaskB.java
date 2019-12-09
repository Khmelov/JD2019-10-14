package by.it.volchek.jd01_14;

import java.io.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
В файле с текстом TaskB.txt нужно подсчитать общее количество знаков
препинания и слов
 Вывести результат на консоль в виде одной строки:
words=123, punctuation marks=15
 Продублировать вывод в консоль в файл resultTaskB.txt
 */
public class TaskB {
    private static String dir (Class<?> cl){
        String path = System.getProperty("user.dir") + File.separator+ "src"+File.separator;
        String clDir=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clDir;
    }

    public static void main(String[] args) {
        try
                (BufferedReader br = new BufferedReader(new FileReader(dir(TaskB.class) + "text.txt"));
                PrintWriter writer = new PrintWriter(new FileWriter(dir(TaskB.class) + "resultTaskB.txt"))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (br.ready()) {

                stringBuilder.append(br.readLine() + "\n");
            }
            Pattern pattern1 = Pattern.compile("[а-яА-ЯёЁ]+");
            Matcher matcher1 = pattern1.matcher(stringBuilder);
            int words = 0;
            int punctuation = 0;
            while (matcher1.find()) {
                words += 1;
            }
            Pattern pattern2 = Pattern.compile("[.,!:;?]");
            Matcher matcher2 = pattern2.matcher(stringBuilder);
            while (matcher2.find()) {
                punctuation += 1;
            }
            System.out.println("words=" + words + ", " + "punctuation marks="+punctuation);
            writer.print("words=" + words + ", " + "punctuation marks="+punctuation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
