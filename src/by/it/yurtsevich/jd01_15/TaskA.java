package by.it.yurtsevich.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {

    public static void main(String[] args) {
        String path = getPath(TaskA.class);
        String filename = path + "matrix.txt";
        int[][] matrix = new int[6][4];
        fillMatrix(matrix);
        printToFile(path, matrix);
        printToConsole(filename);
    }

    private static void fillMatrix(int[][] matrix) {
        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = -15 + rnd.nextInt(15 + Math.abs(15) + 1);
            }
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

    private static void printToFile(String path, int[][] matrix) {
        try (PrintWriter out = new PrintWriter(
                path + "matrix.txt")
        ) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    out.printf("%3d ", matrix[i][j]);
                }
                out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printToConsole(String filename) {
        try (
                BufferedReader br = new BufferedReader(
                        new FileReader(filename))
        ) {
            while (br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
