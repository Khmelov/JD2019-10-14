package by.it.zabauniuk.jd01_05;
import by.it.zabauniuk.jd01_03.InOut;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
//        taskC1();
        taskC2();
    }

    private static void taskC1() {
        int count1 = (int) (20 + Math.random() * (40 - 20 + 1));
        double[] array1 = new double[count1];
        double[] tempArray = new double[count1];
        double x = 5.33;
        double deltaX = (9 - 5.33) / (count1 - 1);
        int j = 0;
        for (int i = 0; i < count1; i++) {
            double z = pow((pow(x, 2) + 4.5), 1.0 / 3);
            array1[i] = z;
            x += deltaX;
            if (z > 3.5) {
                tempArray[j] = array1[i];
                j++;
            }
        }
        InOut.printArray(array1, "A", 5);
        System.out.println();

        double[] array2 = new double[j];
        System.arraycopy(tempArray, 0, array2, 0, j);
        InOut.printArray(array2, "B", 5);
        System.out.println();

        double gMean = array2[0];
        for (int k = 1; k < j; k++) {
            gMean = gMean * array2[k];
        }
        gMean = gMean / j;
        System.out.println("Среднее геометрическое массива 2 = " + gMean);
    }

    private static void taskC2() {
        // create arrays
        int[] arrayA = new int[31];
        int[] tempArray = new int[31];
        int counter = 0;
        for (int i = 0; i < 31; i++) {
            arrayA[i] = (int) (103 + Math.random() * (450 - 103 + 1));
            if ((0.1 * arrayA[i]) > i) {
                tempArray[counter] = arrayA[i];
                counter++;
            }
        }
        int[] arrayB = new int[counter];
        System.arraycopy(tempArray, 0, arrayB, 0, counter);
        Arrays.sort(arrayB);

        //find dimensions for print
        int[] dimensionsA = findDimensions(arrayA);  // dimensions[0] = rows, dimensions[1] = columns
        int[] dimensionsB = findDimensions(arrayB);

        // print array A
//        for (int i = 0; i < arrayA.length; i++) {
//            int number = i+1;
//            System.out.printf("A[%2d]=%-5d", number, arrayA[i]);
//            if (number % dimensionsA[1] == 0) {
//                System.out.println();
//            }
//        }

        // array B - rows to columns
        int rows = dimensionsB[0];
        int columns = dimensionsB[1];
        int[][] reversedArrayB = new int[dimensionsB[0]][dimensionsB[1]];
        int k = 0;
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                while (k < arrayB.length - 1) {
                    reversedArrayB[i][j] = arrayB[k];
                    k++;
                }
            }
        }

    }

    private static int[] findDimensions(int[] array) {
        int minRows = Integer.MAX_VALUE;
        int columns = 0;
        for (int i = 1; i <= 5; i++) {
            int rowsCount = array.length / i;
            if (array.length % i > 0) {
                rowsCount = rowsCount + 1;
            }
            if (rowsCount < minRows) {
                minRows = rowsCount;
                columns = i;
            }
        }
        return new int[]{minRows, columns};
    }
}