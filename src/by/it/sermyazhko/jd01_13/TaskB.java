package by.it.sermyazhko.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double sum = 0;
        double sq = 0;
        double num = 0;
        for (;;){
            String str = scan.nextLine();
            if (str.equals("END")){
                break;
            }
            else{
                try{
                    num = Double.parseDouble(str);
                    sum = sum + num;
                    sq = Math.sqrt(sum);
                    if(Double.toString(sq).equals("NaN")) throw new ArithmeticException();
                    System.out.println("Число:" + num + ", корень суммы чисел:" + sq);
                }catch (NumberFormatException | ArithmeticException | NullPointerException e){
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    for (StackTraceElement element : stackTrace) {
                        if (element.getClassName().equals(TaskB.class.getName())) {
                            int lineNumber = element.getLineNumber();
                            String className = element.getClassName();
                            System.out.printf(" name:%s\nclass:%s\n line:%d\n",
                                    e.getClass().getName(),
                                    className,
                                    lineNumber);
                            break;
                        }
                    }

                }
            }
        }
    }
}
