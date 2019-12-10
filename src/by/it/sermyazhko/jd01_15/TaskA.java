package by.it.sermyazhko.jd01_15;

import java.io.*;
import java.text.Format;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Random;

class TaskA {

    public static void main(String[] args) {
        int[][] arr = new int[6][4];
        createMatrix(arr);
        String paths = getPath(TaskA.class) + "matrix.txt";
        write(paths, arr);
        printToConsole(paths);

    }

    private static int[][] createMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = (int) (Math.random() * (15 * 2 + 1)) - 15;
            }
        }
        return arr;
    }

    private static void write(String paths, int[][] arr) {
        try (FileWriter f = new FileWriter(paths)) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    f.write(String.format("%3d ", arr[i][j]));
                }
                f.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static String getPath(Class<TaskA> aClass) {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator +
                aClass
                        .getName()
                        .replace(aClass.getSimpleName(), "")
                        .replace(".", File.separator);
    }

    private static void printToConsole(String paths) {
        String str = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(paths))) {
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException ex) {
            System.out.println("Ошибка чтения" + ex);
        }
    }
}
