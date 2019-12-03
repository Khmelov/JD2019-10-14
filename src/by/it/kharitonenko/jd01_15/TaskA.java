package by.it.kharitonenko.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {
    //FIELDS
    static int[][] matrix = new int[6][4];

    //METHODS

    /**
     * Generates random integer. Ranges from -max to +max.
     *
     * @param max both maximum and minimum value for range
     * @return random int number, range from -max to max
     */
    public static int randomInt(int max) {
        Random random = new Random();
        int result = random.nextInt(max + 1); //+1 is needed here, since nextInt excludes bound param
        if (random.nextBoolean()) {
            result *= -1;
        }
        return result;
    }

    /**
     * Finds and returns as String value the directory of class.
     *
     * @param cl class name
     * @return directory in which cl resides
     */
    private static String dir(Class<?> cl) {
        return System.getProperty("user.dir") + File.separator + ("src") +
                File.separator + cl.getName().
                replace(cl.getSimpleName(), "").
                replace(".", File.separator);
    }

    public static void main(String[] args) {

        //filling matrix with random numbers
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = randomInt(15);
            }
        }

        //writing results in a txt file
        try
                (PrintWriter writer = new PrintWriter(new FileWriter(dir(TaskA.class) + "matrix.txt"));
                 BufferedReader reader = new BufferedReader(new FileReader(dir(TaskA.class) + "matrix.txt"))) {

            //save matrix in txt file
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    writer.format("%-3d ", matrix[i][j]);
                }
                writer.println();
            }
            writer.close();

            //read matrix from txt file
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
