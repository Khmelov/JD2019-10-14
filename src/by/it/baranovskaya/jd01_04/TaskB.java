package by.it.baranovskaya.jd01_04;

import java.util.Scanner;

public class TaskB {
    private final static int quarter = 4;
    private static int n = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество человек: ");
        n = sc.nextInt();
        String[] surname = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Введите %d - ую фамилию: \n", i);
            surname[i] = sc.next();
        }


        int[][] salary = new int[n][quarter];
        for (int i = 0; i < n; i++) {
            System.out.printf("Введите зарплату для %s:\n", surname[i]);
            for (int j = 0; j < salary[0].length; j++) {
                salary[i][j] = sc.nextInt();
            }
        }

        int total = 0;
        System.out.printf("%-15s%-10s%-10s%-10s%-10s%-10s","Фамилия", "Квартал1",  "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.print(String.format("\n%60s\n","").replace(" ","-"));
        for (int i = 0; i < salary.length; i++) {
            int sum = 0;
            System.out.print(String.format("%-15s",surname[i]));
            for (int j = 0; j < salary[0].length; j++) {
                System.out.printf("%-10d",salary[i][j]);
                sum = sum + salary[i][j];
            }
            total = total + sum;
            System.out.printf("%-55d",sum);
            System.out.println();
        }
        System.out.print(String.format("%60s\n","").replace(" ","-"));
        System.out.print(String.format("%-15s%-10d\n","Итого", total));
        System.out.print(String.format("%-15s%-10.4f", "Средняя",average(salary)));
    }


    private static double average(int[][] arr) {
        double[] sumAverage = new double[quarter];
        double average = 0;
        for (int i = 0; i < arr[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j][i];
            }
            sumAverage[i]=(double)sum/n;
        }

        for (int i = 0; i < sumAverage.length; i++) {
            average += sumAverage[i];
        }

        return (double)average/quarter;
    }
}
