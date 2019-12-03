package by.it.sermyazhko.jd01_13;

import java.text.Format;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;

public class TaskC {
    static byte countOfErrors = 0;
    static Scanner scan;
    static ArrayList<String> ar = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        scan = new Scanner(System.in);
        try{
            for (;;){
                readData() ;
            }
        }catch (Exception e){
            throw new Exception();
        }
    }
    static void readData() throws Exception{
        try{
            String s = scan.nextLine();
            double v = Double.parseDouble(s);
            ar.add(s);
        }catch (Exception e){
                Thread.sleep(100);
            if(countOfErrors==5) {
                throw new Exception();
                    }
            else {
                System.out.println();
                for (int i = ar.size() - 1; i >= 0; i--) {
                    System.out.print( ar.get(i)+".0" + " ");
                }
            }
            ++countOfErrors;
        }
    }
}
