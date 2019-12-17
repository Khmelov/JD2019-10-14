package by.it.zimina.jd02_06.calc_factory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    @Test
    public void checkScalarSumOperation() throws Exception {
        String expression="A=2+5.3";
        Parser parser = new Parser();
        String actual = parser.calc(expression).toString();
        String expected="7.3";
        assertEquals(expected,actual);
    }

    @Test
    public void checkScalarMulOperation() throws Exception {
        String expression="A=7.3 * 3.5";
        Parser parser = new Parser();
        String actual = parser.calc(expression).toString();
        String expected="25.55";
        assertEquals(expected,actual);
    }

    @Test
    public void checkScalarDivOperation() throws Exception {
        String expression="A=15 / 2";
        Parser parser = new Parser();
        String actual = parser.calc(expression).toString();
        String expected="7.5";
        assertEquals(expected,actual);
    }

    @Test
    public void checkScalarSubOperation() throws Exception {
        String expression="A=15 - 7";
        Parser parser = new Parser();
        String actual = parser.calc(expression).toString();
        String expected="8.0";
        assertEquals(expected,actual);
    }
}
