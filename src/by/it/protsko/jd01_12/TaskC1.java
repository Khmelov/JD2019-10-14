package by.it.protsko.jd01_12;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class TaskC1 {
    private static long startTime;
    static {
        startTime = System.nanoTime();
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();
        fillCollection(map);
        printCollection(map);
        deleteDoubleValue(map);
        printCollection(map);
    }

    private static int getUniqueCode() {
        return (int) ((System.nanoTime() - startTime) % 1000000);
    }

    private static void fillCollection(Map<Integer, String> map) {
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            String line = sc.next();
            if (line.equals("end")) {
                break;
            } else {
                map.put(getUniqueCode(), line);
            }
        }
    }

    private static void deleteDoubleValue(Map<Integer, String> map) {
        TreeMap<Integer, String> newMap = new TreeMap<>();
        for (Map.Entry<Integer, String> kvEntry : map.entrySet()) {
            Integer key = kvEntry.getKey();
            String value = map.get(key);
            if (!newMap.containsValue(value)) {
                newMap.put(key, value);
            }
        }
        map.clear();
        for (Map.Entry<Integer, String> kvEntry : newMap.entrySet()) {
            Integer key = kvEntry.getKey();
            map.put(key, newMap.get(key));
        }
    }

    private static void printCollection(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> element : map.entrySet()) {
            System.out.print(element.getValue() + "=" + element.getKey() + " ");
        }
        System.out.println();
    }
}