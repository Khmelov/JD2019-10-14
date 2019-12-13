package by.it.zabauniuk.jd01_15;

import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        int[][] array = new int[6][4];
        for (int i = 0; i < array.length; i++) {
            for(int j=0; j < array[i].length; j++)
                array[i][j] = (int) (Math.random() * 31) - 15;
        }
        String path = getPath(TaskA.class);
        String filename = path + "matrix.txt";
        try (PrintWriter outFile = new PrintWriter(new FileWriter(filename))){
            for (int[] row : array) {
                for (int element: row) {
                    outFile.printf("%3d ", element);
                }
                outFile.println();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        try (BufferedReader inFile = new BufferedReader(new FileReader(filename))) {
            while (inFile.ready())
                System.out.println(inFile.readLine());

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    private static String getPath(Class<?> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String subPath = taskAClass.getName().replace(".", File.separator).replace(taskAClass.getSimpleName(), "");
        String path = rootProject + File.separator + "src" + File.separator + subPath;
        return path;
    }
}