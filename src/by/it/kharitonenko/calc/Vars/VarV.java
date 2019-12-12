package by.it.kharitonenko.calc.Vars;

import by.it.kharitonenko.calc.CalcException;
import by.it.kharitonenko.calc.Interfaces.*;

public class VarV extends Var implements IVar, IAdd, ISub, IMul, IDiv {
    VarS[] value;

    public VarS[] getValue() {
        return value;
    }

    public VarV(VarS[] value) {
        this.value = value;
    }

    public VarV(String stringVarV) {
        StringBuilder sb = new StringBuilder(stringVarV);
        String str = sb.toString().trim();
        str = str.replace("{", "").replaceAll("\\s", "");
        String[] arrayString = str.split("[^\\d.-]+");
        VarS[] varS = new VarS[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            varS[i] = new VarS(arrayString[i]);
        }
        this.value = varS;
    }

    public VarV(VarV otherVarV) {
        this.value = otherVarV.value;
    }

    @Override
    public Var add(Var otherV) throws CalcException {
        if (otherV instanceof VarS) {
            VarS[] result = new VarS[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = (VarS) result[i].add(otherV);
            }
            return new VarV(result);
        } else if (otherV instanceof VarV && value.length == ((VarV) otherV).value.length) {
            VarS[] result = new VarS[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = (VarS) result[i].add(((VarV) otherV).value[i]);
            }
            return new VarV(result);
        } else
            return super.add(otherV);
    }

    @Override
    public Var div(Var otherV) throws CalcException {
        if (otherV instanceof VarS) {
            VarS[] result = new VarS[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = (VarS) result[i].div((otherV));
            }
            return new VarV(result);
        }
        return super.div(otherV);
    }

    @Override
    public Var mul(Var otherV) throws CalcException {
        if (otherV instanceof VarS) {
            VarS[] result = new VarS[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = (VarS) result[i].mul(otherV);
            }
            return new VarV(result);
        } else if (otherV instanceof VarV && value.length == ((VarV) otherV).value.length) {
            VarS[] result = new VarS[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = (VarS) result[i].mul(((VarV) otherV).value[i]);
            }
            return new VarV(result);
        }
        return super.mul(otherV);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        VarV result = new VarV(this.value);
        if (other instanceof VarS) {
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = (VarS) result.value[i].sub(other);
            }
            return result;
        } else if (other instanceof VarV && value.length == ((VarV) other).value.length) {
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = (VarS) result.value[i].sub(((VarV) other).value[i]);
            }
            return result;
        }
        return super.sub(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (VarS element : value) {
            sb.append(delimiter).append(element);
            delimiter = ",";
        }
        sb.append("}");
        return sb.toString();
    }
}
