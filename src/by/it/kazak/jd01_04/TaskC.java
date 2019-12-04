package by.it.kazak.jd01_04;
import by.it.kazak.jd01_03.InOut;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String doubleLine = scanner.nextLine();
        buildOneDimArray(doubleLine);
    }

    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double iFirst = array[0];
        double iLast = array[array.length - 1];
        TaskC.mergeSort(array);
        int newFirst = TaskC.binarySearch(array, iFirst);
        int newLast = TaskC.binarySearch(array, iLast);
        InOut.printArray(array, "V", 4);
        System.out.println("first element=" + newFirst);
        System.out.println("last element=" + newLast);

    }

    private static void mergeSort(double[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            double[] leftArray = new double[mid];
            System.arraycopy(array, 0, leftArray, 0, leftArray.length);
            double[] rightArray = new double[array.length - mid];
            System.arraycopy(array, mid, rightArray, 0, rightArray.length);

            mergeSort(leftArray);
            mergeSort(rightArray);
            double[] result = merge(leftArray, rightArray);
            System.arraycopy(result, 0, array, 0, array.length);
        }
    }

    private static double[] merge(double[] left, double[] right) {
        int size = left.length + right.length;
        double[] merged = new double[size];
        int indexL = 0;
        int indexR = 0;
        int indexM = 0;
        while (indexL < left.length && indexR < right.length) {
            if (left[indexL] <= right[indexR]) {
                merged[indexM] = left[indexL];
                indexL++;
                indexM++;
            } else {
                merged[indexM] = right[indexR];
                indexR++;
                indexM++;
            }
        }
        while (indexL < left.length) {
            merged[indexM] = left[indexL];
            indexL++;
            indexM++;
        }
        while (indexR < right.length) {
            merged[indexM] = right[indexR];
            indexR++;
            indexM++;
        }
        return merged;
    }

    private static int binarySearch(double[] array, double value) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (value == array[middleIndex]) {
                return middleIndex;
            } else if (value > array[middleIndex]) {
                leftIndex = middleIndex + 1;
            } else if (value < array[middleIndex]) {
                rightIndex = middleIndex - 1;
            }
        }
        return -1;
    }
}
