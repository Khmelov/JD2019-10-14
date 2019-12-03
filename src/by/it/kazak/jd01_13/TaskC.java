package by.it.kazak.jd01_13;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {

    private static List<Double> list = new ArrayList<>();
    private static int countException;
    static {countException = 0;}
    private static String text;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            text = sc.nextLine();
            readData();
        }
    }

    private static void readData() throws Exception {
     try {
         double number = Double.parseDouble(text);
         list.add(number);
     } catch (NumberFormatException e) {
         if (countException==5){
             throw new Exception("Количество ошибок превысило 5...");
         }
         countException++;
         Thread.sleep(100);
         for (int i = list.size() - 1; i >= 0; i--) {
             System.out.print(list.get(i) + " ");
         }
         System.out.println();
        }
    }
}
