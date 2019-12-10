package by.it.sermyazhko.calc1;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    @Test
    public void scalarMulTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("A=2*5.1");
        assertEquals("10.2", result.toString());
    }

    @Test
    public void scalarDivTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("B=3/5");
        assertEquals("0.6", result.toString());
    }

    @Test
    public void scalarSubTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("A=2-5.3");
        assertEquals("-3.3", result.toString());
    }

    @Test
    public void scalarAddTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("C=17+2");
        assertEquals("19.0", result.toString());
    }

    @Test
    public void scalarOneTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("A=2+5.3");
        assertEquals("7.3", result.toString());
    }

    @Test
    public void scalarTwoTest() throws Exception{
        Parser parser = new Parser();
        Var result1 = parser.calc("A=2+5.3");
        Var result2 = parser.calc("B=A*3.5");
        assertEquals("25.55", result2.toString());
    }

    @Test
    public void scalarThreeTest() throws Exception{
        Parser parser = new Parser();
        Var result1 = parser.calc("A=2+5.3");
        Var result2 = parser.calc("B=A*3.5");
        Var result = parser.calc("B1=B+0.11*-5");
        assertEquals("25.0", result.toString());
    }

/*
    @Test
    public void scalarDivExceptionTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("G=10/0");
        assertEquals("деление на 0", "деление на 0");
    }*/
}