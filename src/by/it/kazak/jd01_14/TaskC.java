package by.it.kazak.jd01_14;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class TaskC {

    public static void main(String[] args) {
        String name = "kazak";
        String[] packagesNames = getNameOfPackages(name);
        Arrays.sort(packagesNames);
        String [] filesNames = new String[0];
        for (String strPackage : packagesNames) {
            if (strPackage.equals(".DS_Store")) System.out.println("file:.DS_Store");
            else {
                System.out.println();
                System.out.println("dir: "+strPackage);
                filesNames = getNameOfFiles(strPackage, name);
                for (String file : filesNames) {
                    System.out.println("file: " + file);
                }
            }
        }
        saveToFileTxt(packagesNames,filesNames);
    }

    private static String[] getNameOfPackages(String name) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String  wayToPackage = ("by"+File.separator+"it"+File.separator+name);
        File file = new File(src+wayToPackage);
        return file.list();
    }

    private static String[] getNameOfFiles(String nameOfPackage, String name) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String  wayToPackage = ("by"+File.separator+"it"+File.separator+name);
        File file = new File(src+wayToPackage+File.separator+nameOfPackage);
        return file.list();
    }


    private static String getFileName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = TaskC.class.getPackage().getName().replace(".", File.separator);
        return src + strPackage + File.separator + "resultTaskC.txt";
    }


    private static void saveToFileTxt(String[] packages, String[] files) {
        String fileName = getFileName();
        try( PrintWriter printWriter = new PrintWriter(new FileWriter(fileName))) {
            for (String s1 : packages) {
                if (s1.equals(".DS_Store")) printWriter.write("file:.DS_Store\n");
                else {
                    printWriter.write("dir:" + s1 + "\n");
                    for (String s2 : files) {
                        printWriter.write("file:" + s2 + "\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
