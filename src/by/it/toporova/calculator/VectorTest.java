package by.it.toporova.calculator;
import org.junit.Test;

import static org.junit.Assert.*;
public class VectorTest {

    @Test
    public void testScalarAddScalar() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("2+6").toString();
        assertEquals("8.0", res);
    }

    @Test
    public void testScalarSubScalar() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("11-4").toString();
        assertEquals("7.0", res);
    }

    @Test
    public void testScalarMulScalar() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("3*5").toString();
        assertEquals("15.0", res);
    }

    @Test
    public void testScalarDivScalar() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("7/2").toString();
        assertEquals("3.5", res);
    }

    @Test
    public void testVectorAddVector() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("{4.1, 4.2} + {4.6, 5.1}").toString();
        assertEquals("{8.7, 9.3}", res);
    }

    @Test
    public void testVectorAddScalar() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("{4.1, 4.2} + 7").toString();
        assertEquals("{11.1, 11.2}", res);
    }

    @Test
    public void testVectorSubScalar() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("{5.4, 2.2} - 5.4").toString();
        assertEquals("{0.0, -3.2}", res);
    }

    @Test
    public void testVectorSubVector() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("{5.4, 2.2} - {1.4, 0.1}").toString();
        assertEquals("{4.0, 2.1}", res);
    }

    @Test
    public void testVectorMulScalar() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("{3.7, 1.1} * 2").toString();
        assertEquals("{7.4, 2.2}", res);
    }

    @Test
    public void testVectorMulVector() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("{3.7, 1.7} * {2.4, 6.2}").toString();
        assertEquals("19.42", res);
    }

    @Test
    public void testVectorDivScalar() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("{5.5, 3.7} / 2").toString();
        assertEquals("{2.75, 1.85}", res);
    }

    @Test
    public void testMatrixAddScalar() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("{{2.4, 3.7}, {-3.6, 1.7}} + 2").toString();
        assertEquals("{{4.4, 5.7}, {-1.6, 3.7}}", res);
    }

    @Test
    public void testMatrixAddMatrix() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("{{2.4, 3.7}, {3.1, 0.7}} + {{-1.7, 6.1}, {5.1, 6.6}}").toString();
        assertEquals("{{0.7, 9.8}, {8.2, 7.3}}", res);
    }

    @Test
    public void testMatrixSubMatrix() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("{{2.4, 3.1}, {3.7, 4.7}} - {{-1.7, 6.7}, {5.7, 2.6}}").toString();
        assertEquals("{{4.1, -3.6}, {-2.0, 2.1}}", res);
    }

    @Test
    public void testMatrixSubScalar() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("{{2.4, 3.1}, {3.6, 6.5}} - 5").toString();
        assertEquals("{{-2.6, -1.9}, {-1.4, 1.5}}", res);
    }

    @Test
    public void testMatrixMulScalar() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("{{2.4, 3.1}, {3.6, 6.5}} * 5").toString();
        assertEquals("{{12.0, 15.5}, {18.0, 32.5}}", res);
    }

    @Test
    public void testMatrixMulVector() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("{{2.4, 3.1, 2.4}, {3.6, 6.5, 7.1}} * {2.2, 8.1, 4.2}").toString();
        assertEquals("{40.47, 90.39}", res);
    }

    @Test
    public void testMatrixMulMatrix() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("{{2, 1, 3}, {4, 2, 3}, {5, 2, 3}} * {{2, 3, 4}, {1, 5, 2}, {4, 2, 3}}").toString();
        assertEquals("{{17.0, 17.0, 19.0}, {22.0, 28.0, 29.0}, {24.0, 31.0, 33.0}}", res);
    }

    @Test
    public void testMatrixDivScalar() throws Exception{
        Parser p = new Parser();
        String res = p.evaluate("{{2, 5, 3}, {4, 2, 3}, {5, 7, 9}} / 2").toString();
        assertEquals("{{1.0, 2.5, 1.5}, {2.0, 1.0, 1.5}, {2.5, 3.5, 4.5}}", res);
    }


}
