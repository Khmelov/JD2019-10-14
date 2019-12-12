package by.it.toporova.jd02_04;
import org.junit.Test;

import static org.junit.Assert.*;
public class VectorTest {

    @Test
    public void scalarTestA1() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("A = {2,4,6}*{1,2,3}");
        assertEquals("Mul vector error", "{2.0, 8.0, 18.0}",actual.toString());

    }

    @Test
    public void scalarTestA2() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("A = {2,4,6}-{1,2,3}");
        assertEquals("Sub vector error", "{1.0, 2.0, 3.0}",actual.toString());

    }

    @Test
    public void scalarTestA3() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("A = {2,4,6}+{1,2,3}");
        assertEquals("Sum vector error", "{3.0, 6.0, 9.0}",actual.toString());

    }

}
