package by.it.sermyazhko.calc1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    @Test
    public void scalarMulScalarTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("7.3*3.5");
        assertEquals("25.55", result.toString());
    }

    @Test
    public void scalarDivScalarTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("7.3/2");
        assertEquals("3.65", result.toString());
    }

    @Test
    public void scalarSubScalarTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("2-5.3");
        assertEquals("-3.3", result.toString());
    }

    @Test
    public void scalarAddScalarTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("17+2");
        assertEquals("19.0", result.toString());
    }

    @Test
    public void scalarAndVector() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("{1,2,3}*3");
        assertEquals("{3.0, 6.0, 9.0}",result.toString());
    }

    @Test
    public void scalarAndMatrix() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("{{1,2,3},{4,5,6},{7,8,9}}*3");
        assertEquals("{{3.0, 6.0, 9.0}, {12.0, 15.0, 18.0}, {21.0, 24.0, 27.0}}",result.toString());
    }

    @Test
    public void vectorMulVectorTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("{1,2,3}*{1,2,3}");
        assertEquals("14.0", result.toString());
    }

    @Test
    public void vectorAddVectorTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("{1,2,3}+{1,2,3}");
        assertEquals("{2.0, 4.0, 6.0}", result.toString());
    }

    @Test
    public void vectorSubVectorTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("{1,2,3}-{1,2,3}");
        assertEquals("{0.0, 0.0, 0.0}", result.toString());
    }

    @Test
    public void matrixMulVectorTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("{{1,2,3},{4,5,6},{7,8,9}}*{{1,2,3},{4,5,6},{7,8,9}}");
        assertEquals("{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}}", result.toString());
    }

    @Test
    public void matrixAddVectorTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("{{1,2,3},{4,5,6},{7,8,9}}+{{1,2,3},{4,5,6},{7,8,9}}");
        assertEquals("{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}", result.toString());
    }

    @Test
    public void matrixSubVectorTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("{{1,2,3},{4,5,6},{7,8,9}}-{{1,2,3},{4,5,6},{7,8,9}}");
        assertEquals("{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}", result.toString());
    }

    @Test
    public void printMatrixTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("A={{1,2,3},{4,5,6},{7,8,9}}");
        assertEquals("{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}", result.toString());
    }

    @Test
    public void printVectorTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("A={1,2,3}");
        assertEquals("{1.0, 2.0, 3.0}", result.toString());
    }

    @Test
    public void printScalarTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("A=1");
        assertEquals("1.0", result.toString());
    }


    //ууточнить про ошибки обработку
/*
    @Test
    public void vectorDivVectorTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("{1,2,3}/{1,2,3}");
        assertEquals("ERROR:Деление {1.0, 2.0, 3.0} / {1.0, 2.0, 3.0} невозможно", result.toString());
    }*/


/*
    @Test
    public void scalarThreeTest() throws Exception{
        Parser parser = new Parser();
        Var result1 = parser.calc("A=2+5.3");
        Var result2 = parser.calc("B=A*3.5");
        Var result = parser.calc("B1=B+0.11*-5");
        assertEquals("25.0", result.toString());
    }*/

/*
    @Test
    public void scalarDivExceptionTest() throws Exception{
        Parser parser = new Parser();
        Var result = parser.calc("G=10/0");
        assertEquals("деление на 0", "деление на 0");
    }*/

}