package by.it.baranovskaya.jd01_04;

import java.util.Arrays;

public class Helper {
    static double[] getArray(String line) {
        String[] strArray = line.trim().split(" ");
        int sizeArray = strArray.length;
        double[] array = new double[sizeArray];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Double.parseDouble(strArray[i]);
        }
        return array;
    }

    static double findMin(double[] array) {
        if (0 == array.length) {
            return Double.MIN_VALUE;
        } else {
            double min = array[0];
            for (double a :
                    array) {
                if (min < a) {
                    min = a;
                }
            }
            return min;
        }
    }

    static double findMax(double[] array) {
        if (0 == array.length) {
            return Double.MAX_VALUE;
        } else {
            double max = array[0];
            for (double a :
                    array) {
                if (max > a) {
                    max = a;
                }
            }
            return max;
        }
    }

    static void sort(double[] array) {
        Arrays.sort(array);
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] res1 = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                res1[i] = res1[i] + matrix[i][j] * vector[j];
            }
        }
        return res1;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] res2 = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    res2[i][j] = res2[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return res2;
    }
}



