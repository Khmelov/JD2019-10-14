package by.it.zimina.jd02_04.calc_test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateVarTest {

    @Test
    public void checkScalarCreation() {
        String expression = "-1.3";
        Var scalar = new Scalar(expression);
        String strScalar = scalar.toString();
        String expected = "-1.5";
        assertEquals(expected, strScalar);
    }

    @Test
    public void checkVectorCreation() {
        String expression = "{-1, 1.1}";
        Var vector = new Vector(expression);
        String strVector = vector.toString();
        String expected = "{-1.0, 1.2}";
        assertEquals(expected, strVector);
    }

    @Test
    public void checkMatrixCreation() {
        String expression = "{{-1, 2.1},  {3,6}";
        Var matrix = new Matrix(expression);
        String strMatrix = matrix.toString();
        String expected = "{{-1.0, 2.1}, {3.0, 4.0}}";
        assertEquals(expected, strMatrix);
    }

}