package by.it.volchek.jd01_07;

import java.util.Arrays;

public class Vector extends Var{
    double [] value;
    Vector(double[ ] value) {
        this.value=value;
    }
    Vector(Vector vector) {
        this.value=vector.value;
    }
    Vector(String strVector) {
        strVector = strVector.replaceAll("[\\{\\} ]","");
        String [] array = strVector.split(",");
        double [] x = new double[array.length];
        for (int i = 0; i < x.length; i++) {
            x[i]=Double.parseDouble(array[i]);
        }
        this.value=x;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < value.length; i++) {
            stringBuilder.append(value[i]).append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","))
                .deleteCharAt(stringBuilder.lastIndexOf(" "))
                .append("}");
        return stringBuilder.toString();
    }
}
