package by.it.yaroshenko.jd01_09;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    Matrix(double[][] value) {
        double[][] valae_new = new double[value.length][value[0].length];
        for (int i = 0; i < valae_new.length; i++)
            System.arraycopy(value[i], 0, valae_new[i], 0, valae_new[0].length);
        this.value=valae_new;

    }
    Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }
    Matrix(String strValue) {
        String[] str_array = strValue.split("},");
        String[] w=new String[0];
        StringBuilder sb = new StringBuilder(Arrays.toString(str_array));
        Pattern pattern = Pattern.compile("[\\d.d]+");
        Matcher matcher= pattern.matcher(sb);
        while (matcher.find()) {
            int last=w.length; //Последнй элемент
            w= Arrays.copyOf(w, last+1); //копируем массив, увеличиваем его на 1
            w[last]=matcher.group(); //запомним слово
    }
        int count=0;
        int row=str_array.length;
        int col=w.length/str_array.length;
        double[][] matrix = new double[row][col];
        for (int i = 0; i < str_array.length; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j]=Double.parseDouble(w[count]);
                count++;
            }
        }

      this.value=matrix;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Matrix array = new Matrix(this.value);
            this.value=Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < array.value.length; i++) {
                for (int j = 0; j < array.value[i].length; j++) {
                    array.value[i][j] +=((Scalar) other).getValue();
                }
            }
            return array;
        } else if (other instanceof Matrix) {
            Matrix array = new Matrix(Arrays.copyOf(value, value.length));
            for (int i = 0; i < array.value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    array.value[i][j] += ((Matrix) other).getValue()[i][j];
                }
            }
            return new Matrix(array);
        }
            return super.add(other);
        }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Matrix array = new Matrix(this.value);
            this.value=Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < array.value.length; i++) {
                for (int j = 0; j < array.value[i].length; j++) {
                    array.value[i][j] -=((Scalar) other).getValue();
                }
            }
            return new Matrix(array);
        } else if (other instanceof Matrix) {
            Matrix array = new Matrix(Arrays.copyOf(value, value.length));
            for (int i = 0; i < array.value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    array.value[i][j] -= ((Matrix) other).getValue()[i][j];
                }
            }
            return new Matrix(array);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        this.value=Arrays.copyOf(value,value.length);
        Matrix result = new Matrix(value);
        if (other instanceof Matrix){
            double[][] result0 = new double[result.value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < result.value.length; i++)
                for (int j = 0; j < ((Matrix) other).value[0].length; j++)
                    for (int k = 0; k < ((Matrix) other).value.length; k++)
                        result0[i][j] += result.value[i][k] * ((Matrix) other).value[k][j];
            return new Matrix(result0);
        }
        if (other instanceof Scalar){
            for (int i = 0; i < result.value.length; i++) {
                for (int j = 0; j < result.value[i].length; j++) {
                    result.value[i][j]*=((Scalar) other).getValue();
                }
            }
            return result;
        }
        if (other instanceof Vector){
            double[] resultVector = new double[value.length];
            for (int i = 0; i < result.value.length; i++)
                for (int j = 0; j < resultVector.length; j++)
                    resultVector[i] += result.value[i][j] * ((Vector) other).getValue()[j];
            return new Vector(resultVector);
        }
        return super.mul(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        for (int i = 0; i < value.length; i++) {
            String delimiter = "";
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                delimiter=", ";
            }
            if(i<value.length-1) {
                sb.append("}, {");
            }
        }
        sb.append("}}");
        return sb.toString();
    }
}
