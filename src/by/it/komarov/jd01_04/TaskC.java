package by.it.komarov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        double[] arr = new double[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 30);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }

        System.out.println();
        mergeSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + (mergeSort(arr)[i]));
        }

//        String line = "23 45 65 23 54 65 13 41 31 45 64 78 45";
//
//        printMulTable();
//        buildOneDimArray(line);
//
//        Scanner scanner = new Scanner(System.in);
//        String line2 = scanner.nextLine();
//
//        buildOneDimArray(line2);
    }


    private static void printMulTable(){

        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i*j);
            }
            System.out.println();
        }
    }


    private static double[] mergeSort(double[] array) {
        if (array.length <= 1) {
            return array;
        }
        double[] first = new double[array.length / 2];
        double[] second = new double[array.length - first.length];
        System.arraycopy(array, 0, first, 0, first.length);
        System.arraycopy(array, first.length, second, 0, second.length);

        mergeSort(first);
        mergeSort(second);

        merge(first, second, array);
        return array;
    }

    private static void merge(double[] first, double[] second, double[] result) {
        int iFirst = 0;
        int iSecond = 0;
        int iMerged = 0;
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[iMerged] = first[iFirst];
                iFirst++;
            } else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }

    private static int binarySearch(double[] array, double value) {
        int high = array.length - 1;
        int low = 0;
        int mid = (high + 1) / 2;
        int index = -1;

        while (low <= high) {

            if (array[mid] < value) {
                low = mid + 1;
            } else if (array[mid] == value) {
                index = mid;
                System.out.println("Found");
                break;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        if (low > high) {
            System.out.println("Fail");
        }
        return index;
    }

    private static void buildOneDimArray(String line) {

        double[] array = InOut.getArray(line);
        System.out.println("Unsorted array");
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length-1];
        Helper.sort(array);
        System.out.println("Sorted array");
        InOut.printArray(array, "v", 4);

        System.out.printf("%nIndex of first element=%d", Arrays.binarySearch(array, first));
        System.out.printf("%nIndex of last element=%d", Arrays.binarySearch(array, last));
    }
}
