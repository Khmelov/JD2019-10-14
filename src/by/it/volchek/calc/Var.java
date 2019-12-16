package by.it.volchek.calc;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();


    static void set(String name, Var var) {
        vars.put(name, var);
    }

    static Var get(String name) {
        return vars.get(name);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format(ConsoleRunner.lang.get(Errors.ADD_ERROR), this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format(ConsoleRunner.lang.get(Errors.SUB_ERROR), this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format(ConsoleRunner.lang.get(Errors.MUL_ERROR), this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format(ConsoleRunner.lang.get(Errors.DIV_ERROR), this, other));
    }

    @Override
    public String toString() {
        return "abstract Var";
    }

    public static Var createVar(String strVar) throws CalcException {
        strVar = strVar.trim().replace("\\s+", "");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else if (vars.containsKey(strVar))
            return vars.get(strVar);
        else
            throw new CalcException(ConsoleRunner.lang.get(Errors.INT_ERROR));
    }

    static void save()  {
        try (PrintWriter writer = new PrintWriter(getFileName())) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                writer.printf("%s=%s\n", pair.getKey(), pair.getValue().toString());
            }
        } catch (IOException e) {
            System.out.println(ConsoleRunner.lang.get(Errors.UNKWN_ERROR));
        }
    }

    static void saveVar(String name, Var var) {
        vars.put(name, var);
        save();
    }


    static void load() {
        try {
            Parser parser = new Parser();
            for (String line : Files.lines(Paths.get(getFileName()))
                    .collect(Collectors.toList())
                    ) {
                parser.evaluate(line);
            }
        } catch (IOException | CalcException e) {
            System.out.println(ConsoleRunner.lang.get(Errors.FILE_ERROR));
        }


    }

    private static String getFileName() {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator +
                Var.class
                        .getName()
                        .replace(Var.class.getSimpleName(), "")
                        .replace(".", File.separator) + "vars.txt";
    }

}
