package by.it.yaroshenko.calc;

import java.util.Map;

public class Printer {
    void print(Var var) {
        if (var != null) {
            System.out.println(var);
        }
    }
    void printHashMap(Map vars)  {
        System.out.println(vars);
    }
    void printTreeMap(Map vars)  {
        System.out.println(vars);
    }
}
