package by.it.zimina.jd02_04.calc_test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VectorTest {

    @Test
    public void checkVectorAdd() {
        String expression1 = "{1,2}+5.3";
        Parser parser = new Parser();
        String actual = null;
        try {
            actual = parser.calc(expression1).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected1 = "{6.5, 7.5}";
        assertEquals(expected1, actual);
        String expression2 = "{-1,2}+{3.5,4.5}";
        try {
            actual = parser.calc(expression2).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected2 = "{2.5, 6.5}";
        assertEquals(expected2, actual);
    }

    @Test
    public void checkVectorSub() {
        String expression1 = "{10,11.5}-5.6";
        Parser parser = new Parser();
        String actual = null;
        try {
            actual = parser.calc(expression1).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected1 = "{4.5, 6.0}";
        assertEquals(expected1, actual);
        String expression2 = "{-10,10}-{1,-1}";
        try {
            actual = parser.calc(expression2).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected2 = "{-11.0, 11.0}";
        assertEquals(expected2, actual);
    }

    @Test
    public void checkVectorMul() {
        String expression1 = "{10,11.5}*4";
        Parser parser = new Parser();
        String actual = null;
        try {
            actual = parser.calc(expression1).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected1 = "{20.0, 23.0}";
        assertEquals(expected1, actual);
        String expression2 = "{-10,10}*{1,-1}";
        try {
            actual = parser.calc(expression2).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected2 = "-20.0";
        assertEquals(expected2, actual);
    }

    @Test
    public void checkVectorDiv() {
        String expression1 = "{10,11.5}/7";
        Parser parser = new Parser();
        String actual = null;
        try {
            actual = parser.calc(expression1).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected1 = "{5.0, 5.75}";
        assertEquals(expected1, actual);
    }
}
