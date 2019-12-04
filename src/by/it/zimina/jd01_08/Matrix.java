package by.it.zimina.jd01_08;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
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
