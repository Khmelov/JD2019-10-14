package by.it.yaroshenko.calc;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {

    @Test
    public void scalarSumTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("A=2+5.3");
        assertEquals("7.3", expectedValue.toString(), "Sum error");
    }

    @Test
    public void scalarSubTest() throws Exception {
        Parser parser = new Parser();
        Var actualValue = parser.calc("A=8-5.4");
        double expected = 2.6;
        double actual = Double.parseDouble(String.valueOf(actualValue));
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void scalarMulTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("A=7*5.3");
        assertEquals("37.1", expectedValue.toString(), "Multiplication error");
    }

    @Test
    public void scalarDivTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("A=12.16/3.8");
        assertEquals("3.2", expectedValue.toString(), "Division error");
    }

    @Test
    public void vectorAddScalarTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("A={4,8}+3");
        assertEquals("{7.0, 11.0}", expectedValue.toString(), "Addition error");
    }

    @Test
    public void vectorAddVectorTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("A={4,8}+{3,4}");
        assertEquals("{7.0, 12.0}", expectedValue.toString(), "Addition error");
    }

    @Test
    public void vectorSubScalarTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("A={4,8}-3");
        assertEquals("{1.0, 5.0}", expectedValue.toString(), "Subtraction error");
//        Var expectedValue1 = parser.calc("A={4,8}-5");
//        assertEquals("{-1.0, 3.0}", expectedValue.toString(), "Subtraction error");
    }

    @Test
    public void vectorSubVectorTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("A={4,8}-{3,4}");
        assertEquals("{1.0, 4.0}", expectedValue.toString(), "Subtraction error");
    }

    @Test
    public void vectorMulScalarTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("A={4,8}*3");
        assertEquals("{12.0, 24.0}", expectedValue.toString(), "Multiplication error");
    }

    @Test
    public void vectorMulVectorTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("A={4,8}*{3,4}");
        assertEquals("44.0", expectedValue.toString(), "Multiplication error");
    }

    @Test
    public void vectorDivScalarTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("A={12,9}/3");
        assertEquals("{4.0, 3.0}", expectedValue.toString(), "Division error");
    }

    @Test
    public void scalarExpressionTest() throws Exception {
        Parser parser = new Parser();
        Var actualValue = parser.calc("A=8-5*4+12+9/4");
        double expected = 2.25;
        double actual = Double.parseDouble(String.valueOf(actualValue));
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void MatrixSumScalarTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("A=3+{{2,3},{4,5}}");
        assertEquals("{{5.0, 6.0}, {7.0, 8.0}}", expectedValue.toString(), "Sum error");
    }

    @Test
    public void MatrixSumMatrixTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("A={{7,1},{4.5,5.7}}+{{2,3},{4,5}}");
        assertEquals("{{9.0, 4.0}, {8.5, 10.7}}", expectedValue.toString(), "Sum error");
    }

    @Test
    public void MatrixSubScalarTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("A={{2,3},{4,5}}+3");
        assertEquals("{{5.0, 6.0}, {7.0, 8.0}}", expectedValue.toString(), "Substraction error");
    }

    @Test
    public void MatrixSubMatrixTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("A={{7,1},{4.5,5}}-{{2,3},{4,5}}");
        assertEquals("{{5.0, 2.0}, {0.5, 0.0}}", expectedValue.toString(), "Substraction error");
    }

    @Test
    public void MatrixMulScalarTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("A={{2,3},{4,5}}*3");
        assertEquals("{{6.0, 9.0}, {12.0, 15.0}}", expectedValue.toString(), "Multiplication error");
    }

    @Test
    public void MatrixMulVectorTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("A={{2,3},{4,5}}*{3,7}");
        assertEquals("{27.0, 47.0}", expectedValue.toString(), "Multiplication error");
    }

    @Test
    public void MatrixMulMatrixTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("A={{7,1},{4.5,5}}*{{2,3},{4,5}}");
        assertEquals("{{18.0, 26.0}, {29.0, 38.5}}", expectedValue.toString(), "Multiplication error");
    }

    @Test
    public void scalarTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("A=7+8*0.5");
        assertEquals("11.0", expectedValue.toString(), "Sum error");
    }

    @Test
    public void scalarNumberTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("-789.3");
        assertEquals("-789.3", expectedValue.toString(), "Sum error");
    }

    @Test
    public void VectorTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("B={7,8,3,6}");
        assertEquals("{7.0, 8.0, 3.0, 6.0}", expectedValue.toString(), "Sum error");
    }

    @Test
    public void MatrixrTest() throws Exception {
        Parser parser = new Parser();
        Var expectedValue = parser.calc("C={{7.8,3.6},{6,4}}");
        assertEquals("{{7.8, 3.6}, {6.0, 4.0}}", expectedValue.toString(), "Sum error");
    }
}