package by.it.zabauniuk.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int n=scanner.nextInt();
        int[][] mas;
        mas=step1(n);
        int sum=step2(mas);
        System.out.println("Сумма элементов = " + sum);
        System.out.println("step 3");
        step3(mas);
    }

    private static int[][] step1(int n) {
        int[][] arr=getArr(n);
        while (!(hasArrayValue(n,arr) && hasArrayValue(-n,arr)))
            arr=getArr(n);
        printArray(arr);
        return arr;
    }

    private static void printArray(int[][] arr) {
        for (int[] a : arr) {
            for (int x : a)
                System.out.print(x + " ");
            System.out.println();
        }
    }

    private static int[][] getArr(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                arr[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
            }
        }
        return arr;
    }

    private static boolean hasArrayValue(int n, int[][] arr) {
        for (int[] a : arr)
            for (int x : a)
                if (x == n)
                    return true;
        return false;
    }

    private static int step2(int[][] mas) {
        int sum = 0;
        for (int a[] : mas) {
            int i = 0;
            while ((i < a.length) && (a[i] < 0))
                i++;
            i++;
            while ((i < a.length) && (a[i] < 0)) {
                System.out.print(a[i] + " ");
                sum += a[i++];
            }
            System.out.println();
        }
        return sum;
    }

    private static int[][] step3(int[][] mas) {
        printArray(mas);
        int max = getMaxElement(mas);
        System.out.println("Max value is " + max);
        int[][] arr = removeColRow(mas, max);
        printArray(arr);
        return arr;
    }

    private static int[][] removeColRow(int[][] mas, int max) {
        for (int r = 0; r < mas.length; r++)
            for (int c = 0; c < mas[r].length; c++)
                if (mas[r][c] == max) {
                    int[][] arr = getRestrictedArray(mas, r, c, max);
                    return removeColRow(arr, max);
                }
        return mas;
    }

    private static int[][] getRestrictedArray(int[][] mas, int row, int col, int max) {
        int [] rowArr = new int [mas.length - row];
        int [] colArr = new int [mas[0].length - col];
        int i;
        for ( i = 0; i < rowArr.length; i++)
            rowArr[i] = (mas[row + i][col] == max)? row +i : -1;
        for ( i = 0; i < colArr.length; i++)
            colArr[i] =(mas[row][col+i] == max)? col+i : -1;
        int[][] arr = mas;
        for (i=rowArr.length-1; i >=0; i--)
            if (rowArr[i] >= 0)
                arr = deleteRow(arr, rowArr[i]);
        for (i=colArr.length-1; i >=0; i--)
            if (colArr[i] >= 0)
                arr = deleteCol(arr, colArr[i]);
        return arr;
    }

    private static int[][] deleteRow(int[][] mas, int row) {
        int[][] arr = new int[mas.length - 1][];
        int r = 0;
        for (int i = 0; i < mas.length; i++) {
            if (i == row) {
                r = 1;
                continue;
            }
            arr[i - r] = new int[mas[i].length];
            for (int j = 0; j < mas[i].length; j++)
                arr[i - r][j] = mas[i][j];
        }
        return arr;
    }

    private static int[][] deleteCol(int[][] mas, int col) {
        int[][] arr = new int[mas.length][];
        for (int i = 0; i < mas.length; i++) {
            int c = 0;
            arr[i] = new int[mas[i].length - 1];
            for (int j = 0; j < mas[i].length; j++) {
                if (j == col) {
                    c = 1;
                    continue;
                }
                arr[i][j - c] = mas[i][j];
            }
        }
        return arr;
    }

    private static int getMaxElement(int[][] mas) {
        int max = Integer.MIN_VALUE;
        for (int a[] : mas)
            for (int x : a)
                if (x > max)
                    max = x;
        return max;
    }
}
