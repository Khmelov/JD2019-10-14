package by.it.kharitonenko.calc.Vars;

import by.it.kharitonenko.calc.CalcException;
import by.it.kharitonenko.calc.Interfaces.*;

public class VarS extends Var implements IVar, IAdd, ISub, IMul, IDiv {
    double value;

    public double getValue() {
        return value;
    }

    public VarS(double value) {
        this.value = value;
    }

    public VarS(VarS otherVarS) {
        this.value = otherVarS.value;
    }

    public VarS(String stringVarS) {
        this.value = Double.parseDouble(stringVarS);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other.toString().matches(IPatterns.SCALAR)) {
            return new VarS(this.value + ((VarS) other).value);
        }
        return other.add(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other.toString().matches(IPatterns.SCALAR) && ((VarS) other).value != 0) {
            if (((VarS) other).value == 0) {
                throw new CalcException("деление на ноль.");
            }
            return new VarS((this.value / ((VarS) other).value));
        }
        return super.div(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other.toString().matches(IPatterns.SCALAR)) {
            return new VarS(this.value * ((VarS) other).value);
        }
        return other.mul(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other.toString().matches(IPatterns.SCALAR)) {
            return new VarS(this.value - ((VarS) other).value);
        } else
            return super.sub(other);
    }

    @Override
    public String toString() {
        return Double.toString(this.value);
    }
}
