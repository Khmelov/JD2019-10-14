package by.it.kharitonenko.calc.Vars;

import by.it.kharitonenko.calc.*;
import by.it.kharitonenko.calc.Interfaces.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Var implements IVar, IAdd, ISub, IMul, IDiv, IPatterns {

    private static Map<String, Var> vars = new HashMap<>();

    public static Var getVars(String name) {
        return vars.get(name);
    }

    public static Var setVars(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    @Override
    public String toString() {
        return "[abstract Var]";
    }

    public static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(IPatterns.SCALAR))
            return new VarS(strVar);

        else if (strVar.matches(IPatterns.VECTOR))
            return new VarV(strVar);

        else if (strVar.matches(IPatterns.MATRIX))
            return new VarM(strVar);

        else if (vars.containsKey(strVar))
            return vars.get(strVar);
        else
            throw new CalcException(ConsoleRunner.lang.get(errorMessages.INIT));
    }

    public static void save() {
        try (PrintWriter writer = new PrintWriter(getFileName())) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                writer.printf("%s=%s\n", pair.getKey(), pair.getValue().toString());
            }
        } catch (IOException e) {
            System.out.println(ConsoleRunner.lang.get(errorMessages.FILE));
        }
    }

    public static void load() {
        try {
            Parser parser = new Parser();
            for (String line : Files.lines(Paths.get(getFileName()))
                    .collect(Collectors.toList())
            ) {
                parser.evaluate(line);
            }
        } catch (IOException | CalcException e) {
            System.out.println(ConsoleRunner.lang.get(errorMessages.FILE));
        }
    }

    private static String getFileName() {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator +
                Var.class
                        .getName()
                        .replace(ConsoleRunner.class.getSimpleName(), "")
                        .replace(".", File.separator) + "vars.txt";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(ConsoleRunner.lang.get(errorMessages.ADDITION));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(ConsoleRunner.lang.get(errorMessages.DIVISION));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(ConsoleRunner.lang.get(errorMessages.MULTIPLICATION));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(ConsoleRunner.lang.get(errorMessages.SUBTRACTION));
    }
}
