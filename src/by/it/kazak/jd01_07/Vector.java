package by.it.kazak.jd01_07;

import java.util.Arrays;

 class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value,value.length);
    }
    Vector(Vector vector) {
         this.value = vector.value;
    }
    Vector(String strVector){
        String[] array_str = strVector.replaceAll("[{}]", "").split("[^\\d.]+");
        double[] array_double = new double[array_str.length];
        for (int i = 0; i < array_str.length; i++) {
            array_double[i]=Double.parseDouble(array_str[i]);
        }
        this.value=array_double;
     }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String d = "";
        for (double element : value) {
        sb.append(d).append(element);
        d = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
 }