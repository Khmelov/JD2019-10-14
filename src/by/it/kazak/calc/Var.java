package by.it.kazak.calc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    public static Map<String, Var> getVars() {
        return vars;
    }

    static void saveVar(String name, Var var) {
        vars.put(name, var);
        save();
    }

    static Var createVar(String strVar) throws CalcException {
        strVar = strVar.trim().replace("\\s+", "");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else if (vars.containsKey(strVar))
            return vars.get(strVar);
        throw new CalcException("Невозможно создать " + strVar);
    }

    private static void save() {
        try (PrintWriter out = new PrintWriter(new FileWriter(getFileName()))) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                out.println(pair.getKey() + "=" + pair.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void load() throws CalcException {
        Parser p = new Parser();
        File file = new File(getFileName());
        if (file.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = in.readLine()) != null) {
                    p.evaluate(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getFileName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = Var.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + "vars.txt";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Сложение " + this + " + " + other + " невозможно!");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Вычитание " + this + " + " + other + " невозможно!");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Умножение " + this + " + " + other + " невозможно!");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Деление " + this + " + " + other + " невозможно!");
    }

    @Override
    public String toString() {
        return "Это класс Abstract Var";
    }
}


