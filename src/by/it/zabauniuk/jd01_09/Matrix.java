package by.it.zabauniuk.jd01_09;

public class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value)
    {
        this.value = value;
    }

    Matrix(Matrix otherMatrix)
    {
        this.value = otherMatrix.value;
    }



    Matrix(String  strMatrix) {
        String[] arr = strMatrix.replaceAll("[{ }]","").split(",");
        value = new double[2][2];
        for (int i = 0; i < value.length; i++) {
            value[0][i] = Double.parseDouble(arr[i]);
        }
        int j = 0;
        for (int i = 2; i < arr.length; i++) {
            value[1][j] = Double.parseDouble(arr[i]);
            j++;
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double valueScalar = ((Scalar) other).getValue();
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    result[i][j] = value[i][j] + valueScalar;
                }
            }
            return new Matrix(result);
        }
        if(other instanceof Matrix
                && value.length==((Matrix) other).value.length
                && value[0].length==((Matrix) other).value[0].length) {
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    result[i][j] = value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    result[i][j] = value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        if(other instanceof Matrix
                && value.length==((Matrix) other).value.length
                && value[0].length==((Matrix) other).value[0].length) {
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    result[i][j] = value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[][]result = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    result[i][j] = value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }

        if (other instanceof Vector
                && value[0].length==((Vector) other).getValue().length){
            double[] result = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    result[i] = (value[i][j] * ((Vector) other).getValue()[j]) + result[i];
                }
            }
            return new Vector(result);
        }
        if (other instanceof Matrix
                && value[0].length==((Matrix) other).value.length){
            double[][] result = new double[value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value[0].length; k++) {
                        result[i][k] = (value[i][j] * ((Matrix) other).value[j][k]) + result[i][k];
                    }
                }
            }
            return new Matrix(result);
        }
        return super.mul(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimiter="";

        for (int i = 0; i < value.length; i++) {

            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                if (j<value[0].length-1) {
                    sb.append(", ");
                }
            }
            if (i != value.length - 1) sb.append("}, {");
            else sb.append("}}");
        }
        return sb.toString();
    }
}
