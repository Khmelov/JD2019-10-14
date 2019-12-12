package by.it.toporova.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScalarTest {


    @Test
    public void scalarTestA1() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("A=2+5.3");
        assertEquals("Sum scalar error", "7.3",actual.toString());

    }


    @Test
    public void scalarTestA2() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("B=A*3.5");
        assertEquals("Mul scalar error", "25.55",actual.toString());

    }
    @Test
    public void  scalarTestA3() throws CalcException {
        Parser parser= new  Parser();
        Var actual = parser.evaluate("B1=B+0.11*-5");
        assertEquals("Min scalar error","25.0",actual.toString());
    }

    @Test
    public void  scalarTestA4() throws CalcException {
        Parser parser= new  Parser();
        Var actual = parser.evaluate("B2=A/2-1");
        assertEquals("Div scalar error","2.65",actual.toString());
    }

    @Test
    public void matrixTest() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("{{2,4,6},{1,2,3}}*{{2,3},{2,3},{2,3}}");
        assertEquals("Mul matrix error", "{{24.0, 36.0}, {12.0, 18.0}}",actual.toString());
        actual = parser.evaluate("{{2,4,6},{1,2,3}}-{{2,3,2},{3,2,3}}");
        assertEquals("Sub matrix error", "{{0.0, 1.0, 4.0}, {-2.0, 0.0, 0.0}}",actual.toString());
        actual= parser.evaluate("{{2,4,6},{1,2,3}}+{{2,3,2},{3,2,3}}");
        assertEquals("Sum matrix error", "{{4.0, 7.0, 8.0}, {4.0, 4.0, 6.0}}",actual.toString());
    }

}