package by.it.konovalova.jd01_15;

import java.io.*;

public class TaskA {

    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        fillInMatrix(matrix);
        String path = getPath();
        printToFile(path, matrix);
        readFile(path, matrix);
        printToConsole(matrix);
    }

    private static void fillInMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (-16 + Math.random() * 16);
            }
        }
    }

    private static void printToFile(String path, int[][] matrix) {
        try (PrintWriter out = new PrintWriter(new FileWriter(path + "matrix.txt"))) {
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

    private static void readFile(String path, int[][] matrix) {
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(path + "matrix.txt")))) {
            int[][] matrixNew = new int[6][4];
            int s = dis.readInt();
            while (dis.available() > 0) {
                for (int i = 0; i < matrixNew.length; i++) {
                    for (int j = 0; j < matrixNew[0].length; j++) {
                        matrixNew[i][j] = dis.read();
                    }
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private static void printToConsole(int[][] matrixNew) {
        for (int i = 0; i < matrixNew.length; i++) {
            for (int j = 0; j < matrixNew[0].length; j++) {
                System.out.printf("%3d ", matrixNew[i][j]);
            }
            System.out.println();
        }
    }

    private static String getPath() {
        return System.getProperty("user.dir") + File.separator + "src" + File.separator
                + TaskA.class.getName().
                replace(TaskA.class.getSimpleName(), "").
                replace(".", File.separator);
    }
}

