package by.it.komarov.jd02_06;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation{

    private static Map<String, Var> vars = new HashMap<>();

    static void set(String name, Var var) {
        vars.put(name, var);
    }

    static Var createVar(String operand){
        operand = operand.trim().replace("\\s+", "");
        // Чтобы введеная строка соответствовала регулярному выражению, заменяем пробельные символы на пустое место
        if (operand.matches(Patterns.SCALAR)){
            // Истина - Если введеная строка соответствует matcher()
            return new Scalar(operand);
        }
        if (operand.matches(Patterns.VECTOR)){
            return new Vector(operand);
        }
        if (operand.matches(Patterns.MATRIX)){
            return new Matrix(operand);
        }
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + "+" + other + " не возможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " + this + " - " + other + " не возможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + " * " + other + " не возможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " + this + " / " + other + " не возможна");
        return null;
    }

    @Override
    public String toString(){
        return "Absract Class";
    }
}
