package by.it.kharitonenko.calc.Vars;

import by.it.kharitonenko.calc.CalcException;
import by.it.kharitonenko.calc.Interfaces.*;

public class VarM extends Var implements IAdd, ISub, IMul, IDiv, IVar {

    VarS[][] value;

    public VarS[][] getValue() {
        return value;
    }

    public VarM(VarS[][] value) {
        this.value = value;
    }

    public VarM(VarM otherVarM) {
        this.value = otherVarM.value;
    }

    public VarM(String stringMatrix) {

        String[] strArray = stringMatrix.replaceAll("\\},", "xxx").
                replaceAll(" ", "").
                replaceAll("\\}", "").
                replaceAll("\\{", "").
                trim().split("xxx");

        String[] strRowMatrix = strArray[0].trim().split("[,]");
        VarS[][] lineMatrix = new VarS[strArray.length][strRowMatrix.length];

        for (int i = 0; i < strArray.length; i++) {
            strRowMatrix = strArray[i].trim().split("[,]");
            for (int j = 0; j < strRowMatrix.length; j++) {
                lineMatrix[i][j] = new VarS(strRowMatrix[j]);
            }
        }
        this.value = lineMatrix;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof VarS) {
            VarS[][] temp = this.value;
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    temp[i][j] = (VarS) temp[i][j].add(other);
                }
            }
            return new VarM(temp);
        }
        if (other instanceof VarM &&
                ((VarM) other).value.length == this.value.length &&
                ((VarM) other).value[0].length == this.value[0].length) {
            VarS[][] temp = new VarS[this.value.length][((VarM) other).value[0].length];
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    temp[i][j] = (VarS) this.value[i][j].add(((VarM) other).value[i][j]);
                }
            }
            return new VarM(temp);
        }
        return super.add(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof VarS &&
                ((VarS) other).value != 0) {
            VarS[][] temp = this.value;
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    temp[i][j] = (VarS) temp[i][j].div(other);
                }
            }
            return new VarM(temp);
        }
        return super.div(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof VarS) {
            VarS[][] temp = this.value;
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    temp[i][j] = (VarS) temp[i][j].mul(other);
                }
            }
            return new VarM(temp);
        }
        if (other instanceof VarV &&
                this.value[0].length == ((VarV) other).value.length) {
            VarS[] temp = new VarS[((VarV) other).value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < ((VarV) other).value.length; j++) {
                    temp[i] = (VarS) this.value[i][j].mul(((VarV) other).value[j]);
                }
            }
            return new VarV(temp);
        }

        if (other instanceof VarM &&
                this.value[0].length == ((VarM) other).value.length) {
            VarS[][] temp = new VarS[this.value[0].length][((VarM) other).value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < ((VarM) other).value[0].length; j++) {
                    for (int k = 0; k < ((VarM) other).value.length; k++) {
                        temp[i][j] = (VarS) temp[i][j].add(value[i][k].mul((((VarM) other).value[k][j])));
                    }
                }
            }
            return new VarM(temp);
        }
        return super.mul(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof VarS) {
            VarS[][] sub = new VarS[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, sub[i], 0, this.value[0].length);
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    sub[i][j] = (VarS) sub[i][j].sub((other));
                }
            }
            return new VarM(sub);
        }
        if (other instanceof VarM &&
                ((VarM) other).value.length == this.value.length &&
                ((VarM) other).value[0].length == this.value[0].length) {
            VarS[][] temp = new VarS[this.value.length][((VarM) other).value[0].length];
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    temp[i][j] = (VarS) this.value[i][j].sub(((VarM) other).value[i][j]);
                }
            }
            return new VarM(temp);
        }
        return super.sub(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < this.value.length; i++) {
            sb.append("{");
            for (int j = 0; j < this.value[i].length; j++) {
                sb.append(delimiter).append(this.value[i][j]);
                delimiter = ",";
            }
            delimiter = "";
            if (i != this.value.length - 1) sb.append("},");
            else
                sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }
}
