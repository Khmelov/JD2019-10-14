package by.it.bodukhin.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = 0;

        for (; ; ) {
                String line = scanner.nextLine();
                if(line.equalsIgnoreCase("end")){
                    break;
                }
                try{
                double num = Double.parseDouble(line);
                System.out.println(num);
                sum = sum + num;
                if(sum<0) {
                    throw new ArithmeticException();
                }
                double result = Math.sqrt(sum);
                System.out.println(result);

            } catch (NumberFormatException | ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (element.getClassName().equals(TaskB.class.getName())) {
                        int lineNumber = element.getLineNumber();
                        String className = element.getClassName();
                        System.out.printf(" name:%s\nclass:%s\n line:%d\n",
                                e.getClass().getName(), className, lineNumber);
                        break;
                    }
                }
            }
        }
    }
}
