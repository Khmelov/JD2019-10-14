package by.it.zimina.jd02_04.calc_test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixTest {

    @Test
    public void checkMatrixAdd() {
        String expression1 = "{{1,2},{3,4}}+1.1";
        Parser parser = new Parser();
        String actual = null;
        try {
            actual = parser.calc(expression1).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected1 = "{{2.1, 3.1}, {4.1, 5.1}}";
        assertEquals(expected1, actual);
        String expression2 = "{{1,2},{3,4}}+{{-1,-2},{-3,-4}}";
        try {
            actual = parser.calc(expression2).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected2 = "{{0.0, 0.0}, {0.0, 0.0}}";
        assertEquals(expected2, actual);
    }

    @Test
    public void checkMatrixSub() {
        String expression1 = "{{1,2},{3,4}}-1";
        Parser parser = new Parser();
        String actual = null;
        try {
            actual = parser.calc(expression1).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected1 = "{{0.0, 1.0}, {2.0, 3.0}}";
        assertEquals(expected1, actual);
        String expression2 = "{{1,2},{3,4}}-{{-1,-2},{-3,-4}}";
        try {
            actual = parser.calc(expression2).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected2 = "{{2.0, 4.0}, {6.0, 8.0}}";
        assertEquals(expected2, actual);
    }

    @Test
    public void checkMatrixMul() {
        String expression1 = "{{1,2},{3,4}}*2.5";
        Parser parser = new Parser();
        String actual = null;
        try {
            actual = parser.calc(expression1).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected1 = "{{2.5, 5.0}, {7.5, 10.0}}";
        assertEquals(expected1, actual);

        String expression2 = "{{1,2},{3,4}}*{1,2}";
        try {
            actual = parser.calc(expression2).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected2 = "{5.0, 11.0}";
        assertEquals(expected2, actual);

        String expression3 = "{{1,2},{3,4}}*{{-1,-2},{-3,-4}}";
        try {
            actual = parser.calc(expression3).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected3 = "{{-7.0, -10.0}, {-15.0, -22.0}}";
        assertEquals(expected3, actual);
    }

    @Test
    public void checkMatrixDiv() {
        String expression1 = "{{1,2},{3,4}}/2";
        Parser parser = new Parser();
        String actual = null;
        try {
            actual = parser.calc(expression1).toString();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        String expected1 = "{{0.5, 1.0}, {1.5, 2.0}}";
        assertEquals(expected1, actual);
    }
}