package by.it.volchek.jd01_04;

import java.util.Scanner;

public class TaskB {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] people = new String[sc.nextInt()];
            for (int i = 0; i < people.length; i++) {
                people[i] = sc.next();
            }

            int[][] pay = new int[people.length][4];
            for (int i = 0; i < people.length; i++) {
                System.out.println("Введите зарплату для " + people[i]);
                for (int j = 0; j < 4; j++) {
                    pay[i][j] = sc.nextInt();
                }
            }
            int year = 0;
            int fullPmnt = 0;
            int i = 0;
            for (String name : people) {
                year = 0;
                System.out.print(name);
                for (int j = 0; j < 4; j++) {
                    System.out.printf(" %4d", pay[i][j]);
                    year = year + pay[i][j];
                }
                i++;
                System.out.printf(" %4d", year);
                fullPmnt += year;
                System.out.println();
            }
            System.out.println(fullPmnt);
            System.out.printf("%4.4f",(double)fullPmnt/(4*people.length));
        }
    }

