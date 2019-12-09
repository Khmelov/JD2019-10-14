package by.it.komarov.jd01_15;

import java.io.*;

public class Matrix {

    static int[][] createMatrix() {
        int[][] matrix = new int[6][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * (31)) - 15;
            }
        }
        return matrix;
    }

    static void saveMatrixToFile(int[][] matrix, String filename) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename))) {
            for (int[] row : matrix) {
                for (int element : row) {
                    printWriter.printf("%3d ", element);
                }
                printWriter.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void showMatrix(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {


            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
