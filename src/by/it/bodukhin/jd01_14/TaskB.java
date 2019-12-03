package by.it.bodukhin.jd01_14;

import java.io.*;

public class TaskB {

    private static int wordscount = 0;
    private static int markscount = 0;

    public static void main(String[] args) {
        String path = getPath(TaskB.class);
        String filename = path + "text.txt";
        StringBuilder sb = new StringBuilder();
        readTextFile(filename, sb);
        getCounts(sb);
        printToConole(wordscount,markscount);
        printToFile(path,wordscount,markscount);

    }

    private static void printToFile(String path, int wordscount, int markscount){
        try(PrintWriter out = new PrintWriter(path + "resultTaskB.txt")) {
            out.print("words="+wordscount+
                    ", "+"punctuation marks="+markscount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void readTextFile(String filename, StringBuilder sb){
        try(BufferedReader br = new BufferedReader(
                new FileReader(filename))){
            while (br.ready()) {
                sb.append(br.readLine()).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getCounts(StringBuilder sb){
        String text = new String(sb);
        String[] words = text.split("[\\n,. :\"—;/!-]+");
        String[] marks = text.split("[а-яёА-ЯЁ ]+");
        wordscount = words.length;
        markscount = marks.length-1;
    }

    private static void printToConole(int wordscount, int markscount) {
        System.out.println("words="+wordscount+
                ", "+"punctuation marks="+markscount);
    }

    private static String getPath(Class<TaskB> bClass) {
        return System.getProperty("user.dir") +
                File.separator + "src" + File.separator +
                bClass.getName()
                .replace(bClass.getSimpleName(),"")
                .replace(".", File.separator);
    }
}
