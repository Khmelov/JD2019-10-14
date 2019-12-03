package by.it.zabauniuk.jd01_04;

import java.util.Scanner;

public class TaskA {

        public static void main(String[] args) {
            printMulTable();
            Scanner sc=new Scanner(System.in);
            String line=sc.nextLine();
            buildOneDimArray(line);
        }

        static void printMulTable() {
            for (int i=2; i<=9; i++) {
                for (int j=2; j<=9; j++) {
                    System.out.printf("%1d*%1d=%-3d", i, j, i * j);
                }
                System.out.println();
            }
        }

        private static void buildOneDimArray(String line) {
            double[] array=getArray(line);
            printArray(array, "V", 5);
            double first=array[0];
            double last=array[array.length - 1];
            sort(array);
            printArray(array, "V", 4);
            for (int i = 0; i < array.length; i++) {
                if (array[i] == first) {
                    System.out.printf("Index of first element=%d%n", i);
                    break;
                }
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i] == last) {
                    System.out.printf("Index of last element=%d%n", i);
                    break;
                }
            }
        }

        static double[] getArray(String line) {
            line = line.trim();
            String[] arrayString = line.split(" ");
            double[] array = new double[arrayString.length];
            for (int i = 0; i < array.length; i++) {
                array[i] = Double.parseDouble(arrayString[i]);
            }
            return array;

        }

        static void printArray(double[] array) {
            for (double element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        static void printArray(double[] array, String name, int colCount) {
            for (int i = 0; i < array.length; i++) {
                System.out.printf("%s[% -3d]=%-8.3f ", name, i, array[i]);
                if ((i + 1) % colCount == 0) {
                    System.out.println();
                }
            }
            System.out.println();
        }

        public static void sort(double[] arr) {
            boolean swap;
            int last = arr.length - 1;
            do {
                swap = false;
                for (int j = 0; j < last; j++) {
                    if (arr[j] > arr[j + 1]) {
                        double buf = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = buf;
                        swap = true;
                    }
                }
                last--;
            } while (swap);
        }
}
