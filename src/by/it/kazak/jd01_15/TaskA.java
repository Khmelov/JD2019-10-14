package by.it.kazak.jd01_15;

import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        int[][] matrix = createMatrix();
        String filename = getName();
        saveMatrix(matrix, filename);
        showMatrix(filename);
    }

    private static int[][] createMatrix() {
        int[][] matrix = new int[6][4];
        boolean maxOk, minOk;
        do {
            maxOk = false;
            minOk = false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = (int) (Math.random() * (31)) - 15;
                    if (matrix[i][j] == 15) maxOk = true;
                    if (matrix[i][j] == -15) minOk = true;
                }
            }
        } while (!(maxOk && minOk));
        return matrix;
    }

    private static String getName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = TaskA.class.getPackage().getName().replace(".", File.separator);
        return src + strPackage + File.separator + "matrix.txt";
    }

    private static void saveMatrix(int[][] matrix, String filename) {
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

    private static void showMatrix(String filename) {
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
