package by.it.baranovskaya.jd01_04;

import java.util.Scanner;


    public class TaskC {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            buildOneDimArray(s);
        }

         private static void buildOneDimArray(String line) {
            double[] array = InOut.getArray(line);
            InOut.printArray(array, "V", 5);
            System.out.println();

            mergeSort(array);
            InOut.printArray(array, "V", 4);
            System.out.println();
        }


        private static void mergeSort(double[] a) {
            if (a.length < 2) {
                return;
            }
            int mid = a.length / 2;
            double[] l = new double[mid];
            double[] r = new double[a.length - mid];

            for (int i = 0; i < mid; i++) {
                l[i] = a[i];
            }
            for (int i = mid; i < a.length; i++) {
                r[i - mid] = a[i];
            }
            mergeSort(l, mid);
            mergeSort(r, a.length - mid);
            merge(a, l, r, mid, a.length - mid);
        }

        private static void mergeSort(double[] a, int n) {
            if (n < 2) {
                return;
            }
            int mid = n / 2;
            double[] l = new double[mid];
            double[] r = new double[n - mid];

            for (int i = 0; i < mid; i++) {
                l[i] = a[i];
            }
            for (int i = mid; i < n; i++) {
                r[i - mid] = a[i];
            }
            mergeSort(l, mid);
            mergeSort(r, n - mid);
            merge(a, l, r, mid, n - mid);
        }

        private static void merge(double[] a, double[] l, double[] r, int left, int right) {
            int i = 0, j = 0, k = 0;
            while (i < left && j < right) {
                if (l[i] <= r[j]) {
                    a[k++] = l[i++];
                } else {
                    a[k++] = r[j++];
                }
            }
            while (i < left) {
                a[k++] = l[i++];
            }
            while (j < right) {
                a[k++] = r[j++];
            }
        }

        public static int binarySearch(double[] array, double value) {
            int last = array.length - 1;
            int first = 0;

            while (first <= last) {
                int middle = (first + last) / 2;
                if (array[middle] == value)
                    return middle;
                else if (array[middle] < value) {
                    first = middle + 1;
                    System.out.println("Index of first element=" + first);
                } else {
                    last = middle - 1;
                    System.out.println("Index of last element=" + last);
                }
            }
            return -1;
        }
    }
