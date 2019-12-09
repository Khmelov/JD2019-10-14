package by.it.komarov.jd01_14;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Print {
    static void printToFile(String path, int wordscount, int markscount){
        try(PrintWriter out = new PrintWriter(path + "resultTaskB.txt")) {
            out.print("words="+wordscount+
                    ", "+"punctuation marks="+markscount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    static void printToConole(int wordscount, int markscount) {
        System.out.println("words="+wordscount+
                ", "+"punctuation marks="+markscount);
    }
}
