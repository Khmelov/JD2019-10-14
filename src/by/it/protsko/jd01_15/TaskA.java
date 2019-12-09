package by.it.protsko.jd01_15;

import java.io.*;

class TaskA {

    public static void main(String[] args) {
        int[][] matrix = createNatrix(6, 4);
        String fileName = getPath(TaskA.class) + "matrix.txt";
        printMatrixToFile(matrix, fileName);
        printFileToConsole(fileName);
    }


    private static void printMatrixToFile(int[][] matrix, String fileName) {
        try (PrintStream prStr = new PrintStream(new DataOutputStream(new FileOutputStream(fileName)))) {
            for (int[] line : matrix) {
                for (int element : line) {
                    prStr.printf("%3d ", element);
                }
                prStr.println();
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private static void printFileToConsole(String fileName) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }


    private static int[][] createNatrix(int lineSize, int columnSize) {
        int[][] matrix = new int[lineSize][columnSize];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = -15 + (int) (Math.random() * 31);
            }
        }
        return matrix;
    }

    private static String getPath(Class<TaskA> aClass) {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator
                + aClass
                .getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
    }
}