package by.it.toporova.calculator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class ToStringTest {

        @Test
        public void printVarTest() throws Exception {
                Parser parser = new Parser();
                Var actual = parser.evaluate("A=3");
                assertEquals("Var print error", "3.0",actual.toString());
                actual = parser.evaluate("B={2,5,4}");
                assertEquals("Var print error", "{2.0, 5.0, 4.0}",actual.toString());
                actual = parser.evaluate("C={{2,7},{2,9}}");
                assertEquals("Var print error", "{{2.0, 7.0}, {2.0, 9.0}}",actual.toString());
        }
}