package by.it.toporova.calculator_jd02_05_and_jd02_06;

import by.it.toporova.calculator_jd02_05_and_jd02_06.lang.strings.Errors;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Var implements Operation {

   static Map<String, Var> vars = new HashMap<>();

//запись распарсенных значений в файл
    private static String varsFile = (new Path()).getPath(Operation.class,"vars.txt");

    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replace("\\s", "");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (vars.containsKey(operand))
            return vars.get(operand);
        throw new CalcException(ResMan.INSTANCE.get(Errors.VARIABLE) + " " + operand + " "
                + ResMan.INSTANCE.get(Errors.NOT_DEFINED));
    }

    static void saveVar(String nameVar, Var value) {
        vars.put(nameVar, value);
    }

   static void showVar() {
        for (Map.Entry<String, Var> varEntry : vars.entrySet()) {
            System.out.println(varEntry.getKey() + "=" + varEntry.getValue());
        }
    }

   static void showSortVar() {
        Map<String, Var> sortVars = new TreeMap<>(vars);
        for (Map.Entry<String, Var> varEntry : sortVars.entrySet()) {
            System.out.println(varEntry.getKey() + "=" + varEntry.getValue());
        }
    }

    static void saveVarToFile() {
        try (BufferedWriter out =
                     new BufferedWriter(
                             new FileWriter(varsFile, true))) {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                out.write(String.format("%s=%s\n", entry.getKey(), entry.getValue()));
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void loadVarFromFile() {
        if (!new File(varsFile).exists()) return;
        Parser parser = new Parser();
        try (BufferedReader reader = new BufferedReader(new FileReader(varsFile))) {
            for (; ; ) {
                String s = reader.readLine();
                if (s == null)
                    return;
                parser.calc(s);
            }
        } catch (IOException | CalcException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(ResMan.INSTANCE.get(Errors.ADD) + " " + this + " "
                + ResMan.INSTANCE.get(Errors.AND) + " " + other + " " + ResMan.INSTANCE.get(Errors.IMPOSSIBLE));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(ResMan.INSTANCE.get(Errors.SUB) + " " + this + " "
                + ResMan.INSTANCE.get(Errors.OF) + " " + other + " " + ResMan.INSTANCE.get(Errors.IMPOSSIBLE));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(ResMan.INSTANCE.get(Errors.MUL) + " " + this + " "
                + ResMan.INSTANCE.get(Errors.BY) + " " + other + " " + ResMan.INSTANCE.get(Errors.IMPOSSIBLE));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(ResMan.INSTANCE.get(Errors.DIV) + " " + this + " "
                + ResMan.INSTANCE.get(Errors.BY) + " " + other + " " + ResMan.INSTANCE.get(Errors.IMPOSSIBLE));
    }

    @Override
    public String toString() {
        return ResMan.INSTANCE.get(Errors.ERROR_UNEXPECTED_RESULT);
    }

}