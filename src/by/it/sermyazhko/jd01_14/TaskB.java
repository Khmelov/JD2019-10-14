package by.it.sermyazhko.jd01_14;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB {
    public static void main(String[] args) throws IOException {
        String path = getPath(TaskB.class);
        String filename = path + "text.txt";
        StringBuilder sb = new StringBuilder();
        String str;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while ((str = reader.readLine()) != null) {
                sb.append(str + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Ошибка чтения" + ex);
        }
        StringBuilder s = new StringBuilder();
        s.append("words=").append(countWords(sb)).append(", ").append("punctuation marks=").append(punctuationMarks(sb));
        System.out.println(s);

        String filename_ = path + "resultTaskB.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename_))) {
            bw.append(s);

        } catch (IOException ex) {
            System.out.println("Ошибка записи" + ex);
        }
    }

    private static int punctuationMarks(StringBuilder sb){
        Pattern p = Pattern.compile("[,:;-\\\\.!?]");
        Matcher m = p.matcher(sb);
        int count = 0;
        while (m.find()){
            count++;
        }
        return count;
    }

    private static int countWords(StringBuilder sb){
        Pattern p = Pattern.compile("[А-Яа-яёЁ]+");
        Matcher m = p.matcher(sb);
        int count = 0;
        while (m.find()){
            count++;
        }
        return count;
    }

    private static String getPath(Class<TaskB> bClass) {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator +
                bClass
                        .getName()
                        .replace(bClass.getSimpleName(), "")
                        .replace(".", File.separator);
    }
}