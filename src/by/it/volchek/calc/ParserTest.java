package by.it.volchek.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ParserTest {

    @Test
    public void scalarTest() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("A=2+5.3");
        assertEquals("Sum error", "7.3",actual.toString());
        actual = parser.evaluate("B=A*3.5");
        assertEquals("Mul error", "25.55",actual.toString());
        actual = parser.evaluate("B1=B+0.11*-5");
        assertEquals("Mul error", "25.0",actual.toString());
        actual = parser.evaluate("B2=A/2-1");
        assertEquals("Div error", "2.65",actual.toString());
        actual = parser.evaluate("C=B+(A*2)");
        assertEquals("Sum error", "40.15",actual.toString());
        actual = parser.evaluate("D=((C-0.15)-20)/(7-5)");
        assertEquals("Div error", "10.0",actual.toString());
        actual = parser.evaluate("E={2,3}*(D/2)");
        assertEquals("Mul error", "{10.0,15.0}",actual.toString());
    }

    @Test
    public void vectorTest() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("A={1,0}+{1,0}");
        assertEquals("Sum error", "{2.0,0.0}", actual.toString());
    }


}
