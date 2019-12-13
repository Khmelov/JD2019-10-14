package by.it.volchek.jd01_09;

public class Matrix extends Var {
    double [][] value;
    Matrix(double[ ][ ] value) {
        this.value=value;
    }
    Matrix(Matrix matrix){
        this.value=matrix.value;

    }
    Matrix(String strMatrix){
        strMatrix = strMatrix.replaceAll("},","mrg")
                .replaceAll("[\\{}]","");
        String [] strings = strMatrix.split("mrg");
        String [] columns = strings [0].replaceAll(" ","").split(",");
        double [][] array = new double[strings.length][columns.length];
        for (int i = 0; i < strings.length; i++) {
            columns  = strings[i].replaceAll(" ","").split(",");
            for (int j = 0; j < columns.length; j++) {
                array[i][j] = Double.parseDouble(columns[j]);
            }
        }
        this.value=array;

    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < value.length; i++) {
            stringBuilder.append("{");
            for (int j = 0; j < value[i].length; j++) {
                stringBuilder.append(value[i][j]).append(", ");
            }
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","))
                    .deleteCharAt(stringBuilder.lastIndexOf(" "));
            stringBuilder.append("}, ");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","))
                .deleteCharAt(stringBuilder.lastIndexOf(" "))
                .append("}");

        return stringBuilder.toString();

    }
}
