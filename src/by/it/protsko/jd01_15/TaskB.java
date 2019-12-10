package by.it.protsko.jd01_15;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

class TaskB {
    private static StringBuilder sb = new StringBuilder();
    private static long endCommit = 0;

    public static void main(String[] args) {    //start program
        printClassToStringBuilder(sb, getFileName(TaskB.class));
        System.out.println(sb.toString());
        printStringBuilderToFile(sb);
    }


    /*
    null comment number 2
     */
    private static void printStringBuilderToFile(StringBuilder sb) { //print file data to .txt file
        try (PrintWriter out = new PrintWriter(getFileName(TaskB.class).replaceAll(".java", ".txt"))) {
            out.print(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param sb:       stringBuilder
     * @param fileName: it's our fileName
     * @return: nothing
     */
    private static void printClassToStringBuilder(StringBuilder sb, String fileName) {
        try (RandomAccessFile file = new RandomAccessFile(getFileName(TaskB.class), "r")) {
            for (long index = 0; index < file.length(); index++) {
                char ch = (char) file.read();
                long charPosition = file.getFilePointer();

                if (ch == '/' && ((char) file.read() == '/')) {
                    for (int i = (int) file.getFilePointer(); i < file.length(); i++) {
                        if (file.read() == '\n') {
                            endCommit = file.getFilePointer() - 1;
                            break;
                        }
                    }
                    file.seek(endCommit);
                    index = file.getFilePointer() - 1;
                } else {
                    file.seek(charPosition);
                    if (ch == '/' && ((char) file.read() == '*')) {
                        for (int i = (int) file.getFilePointer(); i < file.length(); i++) {

                            char ch1 = (char) file.read();
                            if (ch1 == '*' && (char) file.read() == '/') {
                                endCommit = file.getFilePointer();
                                break;
                            }
                        }
                        file.seek(endCommit);
                        index = file.getFilePointer() - 1;

                    } else {
                        file.seek(charPosition);
                        sb.append(ch);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    it's just null comment
     */
    private static String getFileName(Class<TaskB> bClass) {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator
                + bClass
                .getName()
                .replace(".", File.separator) + ".java";
    }
}