package by.it.protsko.calc;

import by.it.protsko.calc.lang_operations.ResurceManager;
import by.it.protsko.calc.lang_operations.VectorMessages;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    Vector(String strVector) {
        this.value = stringToDoubleArray(strVector);

    }

    private double[] stringToDoubleArray(String strLine) {
        String[] stringArray = strLine.replaceAll("\\{", "").replaceAll("}", "").split(",");
        double[] doubleArray = new double[stringArray.length];
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }
        return doubleArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(value)
                .replace('[', '{')
                .replace(']', '}');
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
            double[] result = new double[value.length];
            System.arraycopy(this.value, 0, result, 0, result.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += scalarValue;
            }
            return new Vector(result);
        }
        if (other instanceof Vector) {
            if (value.length != ((Vector) other).value.length) {
                throw new CalcException(ResurceManager.INSTANSE.getMessage(VectorMessages.ERR_SUM_VECTORS));
            } else {
                double[] result = new double[value.length];
                System.arraycopy(value, 0, result, 0, result.length);
                for (int i = 0; i < result.length; i++) {
                    result[i] += ((Vector) other).value[i];
                }
                return new Vector(result);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
            double[] result = new double[value.length];
            System.arraycopy(value, 0, result, 0, result.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= scalarValue;
            }
            return new Vector(result);
        }
        if (other instanceof Vector) {
            if (value.length != ((Vector) other).value.length) {
                throw new CalcException(ResurceManager.INSTANSE.getMessage(VectorMessages.ERR_SUB_VECTORS));
            } else {
                double[] result = new double[this.value.length];
                System.arraycopy(value, 0, result, 0, result.length);
                for (int i = 0; i < result.length; i++) {
                    result[i] -= ((Vector) other).value[i];
                }
                return new Vector(result);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
            double[] result = new double[this.value.length];
            System.arraycopy(this.value, 0, result, 0, result.length);
            for (int i = 0; i < result.length; i++) {
                result[i] *= scalarValue;
            }
            return new Vector(result);
        }

        if (other instanceof Vector) {
            if (value.length != ((Vector) other).value.length) {
                throw new CalcException(ResurceManager.INSTANSE.getMessage(VectorMessages.ERR_MUL_VECTORS));
            } else {
                double resultVector = 0;
                for (int i = 0; i < this.value.length; i++) {
                    resultVector += this.value[i] * ((Vector) other).value[i];
                }
                return new Scalar(resultVector);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
            if (scalarValue == 0) {
                throw new CalcException(ResurceManager.INSTANSE.getMessage(VectorMessages.ERR_DIV_ZERO));
            } else {
                double[] resultVector = new double[this.value.length];
                System.arraycopy(this.value, 0, resultVector, 0, resultVector.length);
                for (int i = 0; i < resultVector.length; i++) {
                    resultVector[i] /= scalarValue;
                }
                return new Vector(resultVector);
            }
        }

        if (other instanceof Vector) {
            throw new CalcException(ResurceManager.INSTANSE.getMessage(VectorMessages.ERR_DIV_VECTORS));
        }
        return super.div(other);
    }
}
