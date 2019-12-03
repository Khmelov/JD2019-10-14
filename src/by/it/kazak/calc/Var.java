package by.it.kazak.calc;

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
        throw new CalcException(String.format("Сложение %s + %s невозможно\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("Вычитание %s - %s невозможно\n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("Умножение %s * %s невозможно\n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Деление %s / %s невозможно\n", this, other));
    }

    @Override
    public String toString() {
        return "abstract Var";
    }


    public static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else if (vars.containsKey(strVar))
            return vars.get(strVar);
        else
            throw new CalcException("Не удалось создать переменную");
    }

    static void save() {
        try (PrintWriter writer = new PrintWriter(getName())) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                writer.printf("%s=%s\n", pair.getKey(), pair.getValue().toString());
            }
        } catch (IOException e) {
            System.out.println("file error");
        }
    }


    static void load() {
        try {
            Parser parser = new Parser();
            for (String line : Files.lines(Paths.get(getName()))
                    .collect(Collectors.toList())
            ) {
                parser.evaluate(line);
            }
        } catch (IOException | CalcException e) {
            System.out.println("file error");
        }


    }

    private static String getName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = Var.class.getPackage().getName().replace(".", File.separator);
        return src + strPackage + File.separator + "vars.txt";
    }
}


