package by.it.sermyazhko.calc1;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    @Test
    public void scalarOneTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("A=2+5.3");
        assertEquals("7.3", result.toString());
    }

    @Test
    public void scalarTwoTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("B=A*3.5");
        assertEquals("25.55", result.toString());
    }

    @Test
    public void scalarThreeTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("B1=B+0.11*-5");
        assertEquals("25.0", result.toString());
    }

    @Test
    public void scalarFourTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("B2=A/2-1");
        assertEquals("2.65", result.toString());
    }
}