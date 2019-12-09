package by.it.yaroshenko.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        int[][] array = new int[4][6];
        addArray(array);
        pushTextToFile(array);
        outText();
    }

    private static String dir() {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = by.it.yaroshenko.jd01_15.TaskA.class.getName().replace(by.it.yaroshenko.jd01_15.TaskA.class.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    private static void outText() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(dir()+"matrix.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void pushTextToFile(int[][] array) {
        try {
            PrintWriter fileWriter = new PrintWriter(dir()+"matrix.txt");
            for (int[] ints : array) {
                for (int anInt : ints) {
                    fileWriter.printf("%3d ", anInt);
                    //System.out.printf("%3 ",);
                }
                fileWriter.printf("\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                Random random = new Random();
                int num = random.nextInt(16 + 15) - 15;
                array[i][j] = num;
            }
        }
    }
}


