package by.it.protsko.calc;

import java.util.Map;

class Printer {

    void print(Var variable) {
        System.out.println(variable);
    }

    static void printVar() {
        for (Map.Entry<String, Var> stringVarEntry : Var.vars.entrySet()) {
            System.out.println(stringVarEntry);
        }
    }

    static void sortVar() {
        for (Map.Entry<String, Var> stringVarEntry : Var.sortVar(Var.vars).entrySet()) {
            System.out.println(stringVarEntry);
        }
    }
}
