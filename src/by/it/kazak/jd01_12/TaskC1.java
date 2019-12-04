package by.it.kazak.jd01_12;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TaskC1 {

    private static Map<Integer, String> map = new TreeMap<>();

    public static void main(String[] args) {
        fillMap();
        printMap();
    }
    private static void printMap(){
        Set<Map.Entry<Integer,String>> entries = TaskC1.map.entrySet();
        for (Map.Entry<Integer,String> entry : entries) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
    private static void fillMap(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.next();
            if (line.equals("end")) break;
            map.put(line.hashCode(),line);
        }
    }
}
