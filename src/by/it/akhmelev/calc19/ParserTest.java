package by.it.akhmelev.calc19;

import org.junit.Test;
import static org.junit.Assert.*;


public class ParserTest {


    @Test
    public void scalarTest() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("A=2+5.3");
        assertEquals("Sum error", "7.3",actual.toString());

    }


}
