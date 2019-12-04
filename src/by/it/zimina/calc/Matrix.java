package by.it.zimina.calc;

class Matrix extends Var {
    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(String strMatrix) {
        String[] row = strMatrix.split("},");
        String[][] col = new String[row.length][];
        for (int i = 0; i < row.length; i++) {
            col[i] = row[i].replaceAll("\\{", "").replaceAll("\\}", "").split(",");
        }
        double[][] matrix = new double[col.length][col[0].length];
        for (int i = 0; i < col.length; i++) {
            for (int j = 0; j < col[i].length; j++) {
                matrix[i][j] = Double.parseDouble(col[i][j]);
            }
        }
        this.value = matrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double[] row : value) {
            String delimiter2 = "";
            sb.append(delimiter);
            sb.append("{");
            for (double element : row) {
                sb.append(delimiter2).append(element);
                delimiter2 = ", ";
            }
            sb.append("}");
            delimiter = ", ";
        }


        sb.append("}");
        return sb.toString();
    }
}
