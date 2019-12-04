package by.it.zabauniuk.jd01_04;

import java.util.Scanner;

public class TaskB  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество людей:");
        int n = sc.nextInt();
        System.out.println("Введите фамилии " + n + " человек");
        String s = sc.nextLine();
        String[] peopleArr = new String[n];
        for (int i = 0; i < n; i++)
            peopleArr[i] = sc.nextLine();
        int[][] salary = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.printf("Введите зарплату по кварталам для %s\n", peopleArr[i]);
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = sc.nextInt();
            }
        }
        System.out.printf("%-15s%-10s%-10s%-10s%-10s%-10s%n", "Фамилия", "Квартал 1", "Квартал 2", "Квартал 3", "Квартал 4", "Итого");
        System.out.println("------------------------------------------------------------");
        int gsum = 0;
        int avg = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            System.out.printf("%-15s", peopleArr[i]);
            int sum = 0;
            for (int j = 0; j < salary[i].length; j++) {
                sum += salary[i][j];
                avg += salary[i][j];
                cnt++;
                System.out.printf("%-10d", salary[i][j]);
            }
            System.out.printf("%-10d%n", sum);
            gsum += sum;
        }
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-15s%-10d%n", "Итого:", gsum);

        System.out.printf("%-15s%-10.4f%n", "Средняя:", (cnt > 0) ? ((double) avg / cnt) : 0);
    }
}


