package by.it.sermyazhko.calc1;

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

    static void printMap(){

        for (Map.Entry<String, Var> elem : vars.entrySet()) {
            if (elem.getValue()!=null) {
                System.out.printf("%s=%s", elem.getKey(), elem.getValue().toString());
                System.out.println();
            }
        }
    }


    static void set(String name, Var var){
        vars.put(name,var);
    }

    static Var get(String name){
        return vars.get(name);
    }

    @Override
    public Var add(Var other) throws CalcException {
        //throw new CalcException(String.format("Сложение %s + %s невозможно\n", this, other));
        throw new CalcException(String.format(ResMan.INSTANCE.get(Errors.VAR_ERRORADD), this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
       // throw new CalcException(String.format("Вычитание %s - %s невозможно\n",this,other));
        throw new CalcException(String.format(ResMan.INSTANCE.get(Errors.VAR_ERRORSUB),this,other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        //throw new CalcException(String.format("Умножение %s * %s невозможно\n",this,other));
        throw new CalcException(String.format(ResMan.INSTANCE.get(Errors.VAR_ERRORMUL),this,other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format(ResMan.INSTANCE.get(Errors.VAR_ERRORDIV), this, other));
    }

    @Override
    public String toString() {
        return "abstract Var";
    }

    static Var createVar(String value) throws CalcException {
       if(value.matches(PatternForExpression.SCALAR)){
           return new Scalar(value);
       }
       else if(value.replaceAll("\\\"","").matches(PatternForExpression.VECTOR)){
           return new Vector(value);
       }
       else if(value.matches(PatternForExpression.MATRIX)){
           return new Matrix(value);
       }
       else if (vars.containsKey(value))
           return vars.get(value);
       else
          // throw new CalcException("Не удалось создать переменную");
           throw new CalcException(ResMan.INSTANCE.get(Messages.VAR_ERRORCREATEVARIAVLE));
    }

    static void save()  {
        try (PrintWriter writer = new PrintWriter(getFileName())) {
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
            for (String line : Files.lines(Paths.get(getFileName()))
                    .collect(Collectors.toList())
            ) {
                parser.calc(line);
            }
        } catch (IOException | CalcException e) {
            System.out.println("file error");
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

