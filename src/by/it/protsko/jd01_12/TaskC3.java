package by.it.protsko.jd01_12;

import java.util.HashMap;
import java.util.Scanner;

class TaskC3 {
    private static HashMap<String, Integer> openBrackets = new HashMap<>();
    private static HashMap<String, Integer> closeBrackets = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();

        openBrackets.put("(", 0);
        openBrackets.put("[", 1);
        openBrackets.put("{", 2);
        closeBrackets.put(")", 0);
        closeBrackets.put("]", 1);
        closeBrackets.put("}", 2);
        System.out.println(expressionCheck(line));
    }

    private static boolean expressionCheck(String line) {
        int[] openBracketsCount = new int[openBrackets.size()];
        String lastContainsBracket = "";
        int count = 0;

        for (int i = 0; i < line.length(); i++) {
            char character = line.charAt(i);
            String symbol = Character.toString(character);
            if (openBrackets.containsKey(symbol)) {
                openBracketsCount[openBrackets.get(symbol)]++;
                lastContainsBracket = symbol;
                count = 0;
            } else {
                if (closeBrackets.containsKey(symbol)) {
                    if (count == 0) {
                        if (!closeBrackets.get(symbol).equals(openBrackets.get(lastContainsBracket))) {
                            return false;
                        }
                    }
                    openBracketsCount[closeBrackets.get(symbol)]--;
                    count++;
                }
            }
        }
        for (int i : openBracketsCount) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}