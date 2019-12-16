package by.it.zabauniuk.calc;

import java.util.*;

class Printer {
    void print(Var var) {
        if (var != null) {
            System.out.println(var);
        }
    }

    void printMap(Map<String, Var> varMap) {
        if (varMap.isEmpty()) {
            System.out.println("[]");
        }
        for (Map.Entry<String, Var> entry : varMap.entrySet()) {
            System.out.println(entry);
        }
    }

    void printSorted(Map<String, Var> varMap) {
        if (varMap.isEmpty()) {
            System.out.println("[]");
        }
        List<String> keys = new ArrayList<>(varMap.keySet());
        keys.sort(null);
        for (String key : keys) {
            StringBuilder sb = new StringBuilder(key);
            sb.append("=").append(varMap.get(key));
            System.out.println(sb.toString());
        }
    }
}

