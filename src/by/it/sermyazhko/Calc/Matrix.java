package by.it.sermyazhko.Calc;

import java.util.Arrays;

class Matrix extends Var{

    private double[][] val;

    Matrix(double[][] value) {
        val = new double[value.length][];
       /* for (double[] row : value) {
            так правильнее организовывать код, меньше текста
        }*/
        for (int i = 0; i < value.length; i++) {
            val[i] = Arrays.copyOf(value[i],value[i].length);
        }
    }

    Matrix(Matrix matrix){
        val = new double[matrix.val.length][];
        for (int i = 0; i < matrix.val.length; i++) {
            val[i] = Arrays.copyOf(matrix.val[i], matrix.val[i].length);
        }
    }

    Matrix(String strMatrix){
        String [] array = strMatrix.split("(},)");
        val = new double[array.length][];
        for (int i = 0; i < val.length; i++) {
            String[] temp = (array[i].replaceAll("[{}]","")).split("[,]");
            val[i] = new double[temp.length];
            for (int j = 0; j < temp.length; j++) {
                val[i][j] = Double.parseDouble(temp[j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder arr = new StringBuilder();
        arr.append("{{");
        for (int i = 0; i < val.length; i++) {
            for (int j = 0; j < val[0].length; j++) {
                arr.append(val[i][j]);
                if(j < val[0].length - 1)
                    arr.append(", ");
            }
            if(i < val.length - 1){
                arr.append("}, {");
            }
        }
        arr.append("}}");
        return arr.toString();
    }

    public static double[][]  copyMatrix(double[][] value) {
        double[][] newValue = new double[value.length][];
        for (int i = 0; i < value.length; i++) {
            //newValue[i] = new double[value[0].length];
            newValue[i] = Arrays.copyOf(value[i],value[0].length);
        }
        return newValue;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] arr = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    arr[i][j] = arr [i][j] + matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }
        return arr;
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] arr = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                arr[i] = arr[i] + matrix[i][j]*vector[j];
            }
        }
        return arr;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
            double[][] result = copyMatrix(this.val);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] += scalarValue;
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix &&
                val.length == ((Matrix) other).val.length && val[0].length == ((Matrix) other).val[0].length
        ) {
            double[][] result = copyMatrix(this.val);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] += ((Matrix) other).val[i][j];
                }
            }
            return new Matrix(result);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
            double[][] result = copyMatrix(this.val);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] -= scalarValue;
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix &&
                val.length == ((Matrix) other).val.length && val[0].length == ((Matrix) other).val[0].length
        ) {
            double[][] result = copyMatrix(this.val);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] -= ((Matrix) other).val[i][j];
                }
            }
            return new Matrix(result);
        } else
            return super.add(other);
    }


    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
            double[][] result = copyMatrix(this.val);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] *= scalarValue;
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix &&
                val[0].length == ((Matrix) other).val.length
        ) {
            double[][] result = copyMatrix(this.val);
            double[][] temp = mul(result,((Matrix) other).val);
            return new Matrix(temp);
        } else if (other instanceof Vector &&
                val[0].length == ((Vector) other).getValue().length){
            double[][] result = copyMatrix(this.val);
            double[]temp =  mul(result,((Vector) other).getValue());
            return new Vector(temp);
        }
        return super.add(other);
    }


    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
            double[][] result = copyMatrix(this.val);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] /= scalarValue;
                }
            }
            return new Matrix(result);
        } else {
            return super.div(other);
        }
    }
}
