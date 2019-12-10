package by.it.volchek.jd01_09;

public abstract class Var implements Operation {

    static Var createVar(String operand) {
        operand = operand.trim().replace("\\s+","");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        return null;
    }
    @Override
    public Var add(Var other) {
        System.out.printf("Сложение %s + %s невозможно\n",this,other);
        //TODO add exception
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Вычитание %s - %s невозможно\n",this,other);
        //TODO add exception
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Умножение %s * %s невозможно\n",this,other);
        //TODO add exception
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Деление %s / %s невозможно\n",this,other);
        //TODO add exception
        return null;
    }
}
