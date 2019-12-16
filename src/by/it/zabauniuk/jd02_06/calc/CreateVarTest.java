package by.it.zabauniuk.jd02_06.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateVarTest {

    @Test
    public void checkScalarCreation() {
        String expression = "-1.5";
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
        String expected = "{-1.0, 1.1}";
        assertEquals(expected, strVector);
    }

    @Test
    public void checkMatrixCreation() {
        String expression = "{{-1, 2.1},  {3,4}";
        Var matrix = new Matrix(expression);
        String strMatrix = matrix.toString();
        String expected = "{{-1.0, 2.1}, {3.0, 4.0}}";
        assertEquals(expected, strMatrix);
    }

}