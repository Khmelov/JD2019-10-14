package by.it.protsko.calc;

import java.util.HashMap;

class CheckExpression {
    private static HashMap<String, Integer> openBrackets = new HashMap<String, Integer>() {
        {
            this.put("(", 0);
            this.put("[", 1);
            this.put("{", 2);
        }
    };

    private static HashMap<String, Integer> closeBrackets = new HashMap<String, Integer>() {
        {
            this.put(")", 0);
            this.put("]", 1);
            this.put("}", 2);
        }
    };

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

    public static boolean checkExpression(String line) {
        return expressionCheck(line);
    }
}
