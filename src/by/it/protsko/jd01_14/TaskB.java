package by.it.protsko.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TaskB {

    public static void main(String[] args) {
        String path = getPath(TaskB.class);
        String fileName = path + "text.txt";
        StringBuilder sb = new StringBuilder();
        List<String> wordsList = new ArrayList<>();
        List<String> punctuationMarksList = new ArrayList<>();

        sb = convertFileToStringLine(fileName, sb);
        wordsList = createListByStringLine("[-,.:!]+", sb, wordsList);
        punctuationMarksList = createListByStringLine("[а-яёА-ЯЁ]+", sb, punctuationMarksList);
        System.out.print("words=" + wordsList.size() + ", ");
        System.out.println("punctuation marks=" + punctuationMarksList.size());
        printConsoleToFile(path, wordsList, punctuationMarksList);
    }

    private static void printConsoleToFile(String path, List<String> wordsList, List<String> punctuationMarksList) {
        try (PrintWriter out = new PrintWriter(path + "resultTaskB.txt")) {
            out.print("words=" + wordsList.size() + ", ");
            out.print("punctuation marks=" + punctuationMarksList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder convertFileToStringLine(String fileName, StringBuilder sb) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            sb = new StringBuilder();
            while (br.ready()) {
                sb.append(br.readLine()).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    private static List<String> createListByStringLine(String regex, StringBuilder sb, List<String> list) {
        list.clear();
        String words = sb.toString().replaceAll(regex, " ").replaceAll("[\\s]{2,}", " ").trim();
        list = new ArrayList<>(Arrays.asList(words.split(" ")));
        return list;
    }

    private static String getPath(Class<TaskB> aClass) {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator
                + aClass
                .getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
    }
}