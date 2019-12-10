package by.it.toporova.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {


    @Test
    public void scalarTestA1() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("A=2+5.3");
        assertEquals("Sum error", "7.3",actual.toString());

    }


    @Test
    public void scalarTestA2() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("B=A*3.5");
        assertEquals("Sum error", "25.55",actual.toString());

    }
    @Test
    public void  scalarTestA3() throws CalcException {
        Parser parser= new  Parser();
        Var actual = parser.evaluate("B1=B+0.11*-5");
        assertEquals("Sum error","25.0",actual.toString());
    }

    @Test
    public void  scalarTestA4() throws CalcException {
        Parser parser= new  Parser();
        Var actual = parser.evaluate("B2=A/2-1");
        assertEquals("Sum error","2.65",actual.toString());
    }

}