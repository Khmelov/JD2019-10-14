package by.it.zabauniuk.jd01_03;

public class Helper {

    public static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                arr[i] = min;
            }
        }
        return min;
    }

    public static double findMax(double[] arr) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                arr[i] = max;
            }
        }
        return max;
    }

    public static void sort(double[] arr) {
        int count = arr.length - 1;
        boolean flag;
        do {
            flag = false;
            for (int i = 0; i < count; i++) {
                if (arr[i] > arr[i + 1]) {
                    double buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    flag = true;
                }
            }
            count = count - 1;
        }
        while (flag);
    }

    public static double[] mul(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];
            }
        }
        return result;
    }


    public static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] result2 = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixLeft.length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result2[i][j] = result2[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return result2;
    }
}