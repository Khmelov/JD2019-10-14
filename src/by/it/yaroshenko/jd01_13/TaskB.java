package by.it.yaroshenko.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        double sum=0;
        double sum_sqrt;
        while (!((s=scanner.next()).equals("END"))) {
            try {
                double parseDouble = Double.parseDouble(s);
                sum+=parseDouble;
                if(sum<0) {
                    throw new ArithmeticException();
                }
                sum_sqrt=Math.sqrt(sum);
                System.out.println(s+" "+sum_sqrt);
            } catch (NumberFormatException|ArithmeticException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (TaskB.class.getName().equals(element.getClassName())) {
                    System.out.println(element.getClassName());
                    String name = e.getClass().getName();
                    String clname = element.getClassName();
                    int number = element.getLineNumber();
                    System.out.printf(
                            "name: %s\n" +
                                    "class: %s\n" +
                                    "line: %s\n",
                            name, clname, number);
                    break;
                }
            }
                //System.out.println("Вы ввели не число");
            }
//        } catch (Exception e) {
//
//        }
//            StringBuilder sb = new StringBuilder(s);
//            Pattern pattern = Pattern.compile("[\\d]+");
//            Matcher matcher = pattern.matcher(sb);
//            while (matcher.find()) {
//                String word = matcher.group();
            }
        }
    }

