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
    public void scalarTestB1() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("C=B+(A*2)");
        assertEquals("Mul vector error", "40.15",actual.toString());

    }

    @Test
    public void scalarTestB2() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("D=((C-0.15)-20)/(7-5)");
        assertEquals("Sub vector error", "10",actual.toString());

    }

    @Test
    public void scalarTestB3() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("E={2,3}*(D/2)");
        assertEquals("Sum vector error", "{10,15}",actual.toString());

    }




}