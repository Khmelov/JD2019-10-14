package by.it.yaroshenko.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 В файле с текстом TaskB.txt нужно подсчитать общее количество знаков
препинания и слов
 Вывести результат на консоль в виде одной строки:
words=123, punctuation marks=15
 Продублировать вывод в консоль в файл resultTaskB.txt
 */
public class TaskB {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        File file = new File(dir() + "text.txt");

        addList(objects, file);
        printCountWords(objects);
        printCountMark(objects);
        pushTextToFile(objects);
    }

    private static String dir() {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = TaskB.class.getName().replace(TaskB.class.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    private static void pushTextToFile(ArrayList<Object> objects) {
        try {
            FileWriter fileWriter = new FileWriter(dir() + "resultTaskB.txt");
            for (Object object : objects) {
                fileWriter.write(object+"\n");
                System.out.println(object);
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printCountMark(ArrayList<Object> objects) {
        int count1 = 0;
        for (Object object : objects) {
            StringBuilder sb = new StringBuilder(String.valueOf(object));
            Pattern pattern = Pattern.compile("[^а-яА-ЯёЁ\\s]+");
            Matcher matcher = pattern.matcher(sb);
            while (matcher.find()) {
                count1++;
            }
        }
        System.out.println("marks=" + count1);
    }

    private static void printCountWords(ArrayList<Object> objects) {
        int count = 0;
        for (Object object : objects) {
            StringBuilder sb = new StringBuilder(String.valueOf(object));
            Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
            Matcher matcher = pattern.matcher(sb);
            while (matcher.find()) {
                count++;
            }
        }
        System.out.println("words=" + count);
    }

    private static void addList(ArrayList<Object> objects, File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                objects.add(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


