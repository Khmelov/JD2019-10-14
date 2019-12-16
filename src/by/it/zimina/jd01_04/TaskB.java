package by.it.zimina.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] lastname = new String[n];
        for (int i=0; i<lastname.length; i++) {
            lastname[i] = scanner.next();
        }

        int[][] salary = new int[n][4];
        for (int i = 0; i < lastname.length; i++) {
            System.out.println("Введите зарплату для " + lastname[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }

        int[] itog = new int[n];
        for (int i = 0; i < itog.length; i++) {
            itog[i] = 0;
            for (int i1 = 0; i1 < salary[0].length; i1++) {
                itog[i] = (itog[i] + salary[i][i1]);
            }
        }

        System.out.println("-------------------------------------------------------");
        System.out.println("Фамилия   " + "Квартал1  " + "Квартал2  " + "Квартал3  " + "Квартал4  " + "Итого");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < lastname.length; i++) {
            System.out.printf("%7s:  %-10d%-10d%-10d%-10d%-5d", lastname[i], salary[i][0], salary[i][1], salary[i][2], salary[i][3], itog[i]);
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");

        int sum=0;
        for (int i = 0; i < itog.length; i++) {
            sum=sum+itog[i];
        }
        System.out.println("Итого     "+sum);

        double sum1=(double) sum/n/4;
        System.out.printf("%-10s%.4f", "Средняя", sum1);
    }

}
