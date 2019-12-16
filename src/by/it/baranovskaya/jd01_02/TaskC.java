package by.it.baranovskaya.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][]arr = step1(n);
        int sum = step2(arr);
        int[][]arr1 = step3(arr);

    }

    private static int[][] step3(int[ ][ ] arr) {

        int i_max = 0;
        int j_max = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    i_max = i;
                    j_max = j;
                }
            }
        }
        int count = 0;

        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                if (max == ints[j]) {
                    count += 1;
                }
            }
        }

        System.out.println("i_max = " + i_max);
        System.out.println("j_max = " + j_max);

        int arr1[][] = new int[arr.length - 1][arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length; j++) {

                if (i >= i_max) {
                    arr1[i][j] = arr[i + 1][j];
                }
                if (i < i_max) {
                    arr1[i][j] = arr[i][j];
                }
                System.out.print(arr1[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("\n");


        int arr2[][] = new int[arr.length - 1][arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (j >= j_max) {
                    arr2[i][j] = arr1[i][j + 1];
                }
                if (j < j_max) {
                    arr2[i][j] = arr1[i][j];
                }
                System.out.print(arr2[i][j] + " ");
            }
            System.out.print("\n");
        }
        return arr2;
    }

    private static int step2(int[][] arr) {
        int sum = 0;
        int count;
        for (int[] ints : arr) {
            count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (ints[j] > 0 & count == 0) {
                    count = 1;
                    continue;
                }
                if (count == 1 & ints[j] <= 0) {
                    sum += ints[j];
                    continue;
                }
                if (ints[j] > 0 & count == 1) {
                    count = 2;
                    break;
                }
            }
        }
        return sum;
    }

    private static int[][] step1(int n){
        boolean is_n = false;
        boolean is_min_n = false;
        int arr[][] = new int[n][n] ;
        while (true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = rand(-n, n);
                    if (arr[i][j] == n){
                        is_n = true;
                    }
                    if (arr[i][j] == -n){
                        is_min_n = true;
                    }
                }
            }
            if(is_n & is_min_n){
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println("\n");
                }
                break;
            }
        }
        return  arr;
    }

    private static int rand(int min, int max) {
        return (int)(Math.random()*((max-min)+1)) + min;
    }
}
