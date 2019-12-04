package by.it.toporova.calc;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
        System.out.println("double123 " + value);
    }

    public double[] getValue() {
        return value;
    }

    public void setValue(double[] value) {
        this.value = value;
    }

    Vector(String strVector) {//b3
        StringBuilder sb = new StringBuilder(strVector);//
        sb.deleteCharAt(0).deleteCharAt(sb.length() - 1);
        String str = sb.toString();
        String[] arrayString = str.split("[^\\d.]+");//объявление массива и разделение строки на массив по нечисловым разделителям и точке
        double[] arrayDouble = new double[arrayString.length]; //объявление double массива длинной равной длине строкового
        for (int i = 0; i < arrayString.length; i++) { //перебор строкового массива и запись в double
            arrayDouble[i] = Double.parseDouble(arrayString[i]);
        }
        this.value = arrayDouble;
    }

    Vector(Vector vector) { //прием экземпляра класса
        this.value = vector.value; //обращение к классу вектор
    }

    @Override
    public Var add(Var other) throws CalcException { //если другой аргумент - скаляр
        if (other.toString().matches(Patterns.SCALAR)) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {//складываем каждый элемент матрицы со скаляром
                res[i] = res[i] + ((Scalar) other).getValue();

            }
            return new Vector(res);

        } else if (other instanceof Vector) {//если другой элемент - тоже вектор
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];

            }
            return new Vector(res);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other.toString().matches(Patterns.SCALAR)) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {//вычитаем каждый элемент матрицы со скаляром
                res[i] = res[i] - ((Scalar) other).getValue();

            }
            return new Vector(res);
        } else if (other instanceof Vector) {//если другой элемент - тоже вектор
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];

            }
            return new Vector(res);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        double result = 0;
        if (other.toString().matches(Patterns.SCALAR)) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {//вычитаем каждый элемент матрицы со скаляром
                res[i] = res[i] * ((Scalar) other).getValue();

            }
            return new Vector(res);
        } else if (other instanceof Vector) {//если другой элемент - тоже вектор
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                result = (res[i] * ((Vector) other).value[i]) + result;

            }
            return new Scalar(result);
        } else return super.mul(other);

    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other.toString().matches(Patterns.SCALAR)) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();

            }
            return new Vector(res);
        } else return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";

        }
        sb.append("}");

        return sb.toString();
    }
}
