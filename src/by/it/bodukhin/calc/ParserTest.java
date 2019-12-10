package by.it.bodukhin.calc;


import org.junit.Test;
import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void scalarTest() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("2+5.3");
        assertEquals("Sum scalar error","7.3", actual.toString());
        actual = parser.evaluate("7.3*3.5");
        assertEquals("Mul scalar error", "25.55", actual.toString());
        actual = parser.evaluate("25.55-5.55");
        assertEquals("Sub scalar error", "20.0", actual.toString());
        actual= parser.evaluate("20/5");
        assertEquals("Div scalar error", "4.0", actual.toString());
    }

    //@Test
    public void vectorTest() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("{2,4,6}*{1,2,3}");
        assertEquals("Mul vector error", "{2.0, 8.0, 18.0}",actual.toString());
        actual = parser.evaluate("{2,4,6}-{1,2,3}");
        assertEquals("Sub vector error", "{1.0, 2.0, 3.0}",actual.toString());
        actual= parser.evaluate("{2,4,6}+{1,2,3}");
        assertEquals("Sum vector error", "{3.0, 6.0, 9.0}",actual.toString());
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

    @Test
    public void printVarTest() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("A=5");
        assertEquals("Var print error", "5.0",actual.toString());
        actual = parser.evaluate("B={2,6,7}");
        assertEquals("Var print error", "{2.0, 6.0, 7.0}",actual.toString());
        actual = parser.evaluate("C={{1,7},{5,9}}");
        assertEquals("Var print error", "{{1.0, 7.0}, {5.0, 9.0}}",actual.toString());
    }
}