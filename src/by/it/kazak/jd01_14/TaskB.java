package by.it.kazak.jd01_14;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {


    private static String dir() {
        String path = System.getProperty("user.dir")+ File.separator+"src"+ File.separator;
        String clDir = TaskB.class.getName().replace(TaskB.class.getSimpleName(),"").replace(".",File.separator);
        return path+clDir;
    }


    public static void main(String[] args) {
        String fileName = dir()+"text.txt";
        String count = getCounts(fileName);
        //getCounts
        getCounts(fileName);
        System.out.print(count);
        String result = dir() + "resultTaskB.txt";
        outTxt(count, result);
    }

    private static String getCounts(String fileName) {
        String count = "";
        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileName)))
        {

            Pattern pw = Pattern.compile("[а-яА-ЯёЁ]+");
            Pattern ps = Pattern.compile("[,.!?;:-]+");
            int words = 0;
            int signs = 0;
            while (reader.ready()) {
                String s = reader.readLine();
                Matcher matcher1 = pw.matcher(s);
                while (matcher1.find()) words++;

                Matcher matcher2 = ps.matcher(s);
                while (matcher2.find()) signs++;
            }
            count = "words=" + words + ", punctuation marks=" + signs;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    private static void outTxt(String count, String result) {
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(result))
        ) {
            printWriter.write(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
