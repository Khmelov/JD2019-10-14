package by.it.baranovskaya.jd01_07;

import java.util.Arrays;

public class Vector extends Var {
    public double[] value;


    public Vector(double[] value) {
        this.value = Arrays.copyOf(value,value.length);
    }
    public Vector(Vector vector)  { this.value = vector.value; }
    public Vector(String strVector) {
        String[] str = strVector.replace("{", "")
                .replace("}", "")
                .split(",");
        value = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            value[i] = Double.parseDouble(str[i]);
        }
    }
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
    sb.append("{");
            String delimeter = "";
            for(double element : value) {
                sb.append(delimeter).append(element);
                delimeter = ", ";
            }
            sb.append("}");
            return sb.toString();
    }
}