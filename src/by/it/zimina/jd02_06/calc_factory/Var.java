package by.it.zimina.jd02_06.calc_factory;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

   private static Map<String, Var> vars=new HashMap<>();

   static Var saveVar(String name, Var var) {
       vars.put(name, var);
       return var;
   }

    static Var createVar(String strVar) throws CalcException {
        strVar = strVar.trim().replace("\\s+", "");
        VarFactory factory;
        if (strVar.matches(Patterns.SCALAR)) {
            factory = new ScalarFactory();
            return factory.createVar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            factory = new VectorFactory();
            return factory.createVar(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            factory = new MatrixFactory();
            return factory.createVar(strVar);
        } else if (vars.containsKey(strVar))
            return vars.get(strVar);
        throw new CalcException("невозможно создать " + strVar);
    }


    @Override
    public Var add(Var other) throws CalcException {
       throw new CalcException("Операция сложения "+this+"+"+other+" невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания "+this+"-"+other+" невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения "+this+"*"+other+" невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления "+this+"/"+other+" невозможна");
    }
}
