package by.it.konovalova.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void ScalarADD() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("A=2+5.3");
        assertEquals("Sum error", "7.3", actual.toString());
    }
    @Test
    public void ScalarMUL() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("B=A*3.5");
        assertEquals("Mul error", "25.55", actual.toString());
    }
    @Test
    public void ScalarSUB() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("B1=B+0.11*-5");
        assertEquals("Sub error", "25.0", actual.toString());
    }

    @Test
    public void ScalarDIV() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("B=A/2-1");
        assertEquals("Div error", "2.65", actual.toString());
    }

    @Test
    public void VectorADDScalar() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("A={1,2,3}+46");
        assertEquals("Add error", "{47.0, 48.0, 49.0}", actual.toString());
    }
    @Test
    public void VectorADDVector() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("A={1,2,3}+{4,5,6}");
        assertEquals("Add error", "{5.0, 7.0, 9.0}", actual.toString());
    }
    @Test
    public void VectorSUBScalar() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("M={1,2,3}-10");
        assertEquals("Sub error", "{-9.0, -8.0, -7.0}", actual.toString());
    }
    @Test
    public void VectorSUBVector() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("M={1,2,3}-{4,5,6}");
        assertEquals("Sub error", "{-3.0, -3.0, -3.0}", actual.toString());
    }
    @Test
    public void VectorMulScalar() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("N={1,2,3}*10");
        assertEquals("Mul error", "{10.0, 20.0, 30.0}", actual.toString());
    }
    @Test
    public void VectorMulVector() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("N={1,2,3}*{4,5,6}");
        assertEquals("Mul error", "32.0", actual.toString());
    }
    @Test
    public void VectorDivScalar() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("T={10,20,30}/2");
        assertEquals("Div error", "{5.0, 10.0, 15.0}", actual.toString());
    }
    @Test
    public void MatrixADDScalar() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("T={{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}+6");
        assertEquals("Add error", "{{8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}, {20.0, 22.0, 24.0}}", actual.toString());
    }
    @Test
    public void MatrixADDMatrix() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("T={{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}+{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}");
        assertEquals("Add error", "{{3.0, 6.0, 9.0}, {12.0, 15.0, 18.0}, {21.0, 24.0, 27.0}}", actual.toString());
    }
    @Test
    public void MatrixASubScalar() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("T={{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}-5");
        assertEquals("Sub error", "{{-3.0, -1.0, 1.0}, {3.0, 5.0, 7.0}, {9.0, 11.0, 13.0}}", actual.toString());
    }
    @Test
    public void MatrixASubMatrix() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("T={{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}-{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}");
        assertEquals("Sub error", "{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}", actual.toString());
    }
    @Test
    public void MatrixMulScalar() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("T={{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}*15");
        assertEquals("Mul error", "{{30.0, 60.0, 90.0}, {120.0, 150.0, 180.0}, {210.0, 240.0, 270.0}}", actual.toString());
    }
    @Test
    public void MatrixMulVector() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("T={{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}*{1.0, 2.0, 3.0}");
        assertEquals("Mul error", "{28.0, 64.0, 100.0}", actual.toString());
    }
    @Test
    public void MatrixMulMatrix() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("T={{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}*{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}");
        assertEquals("Mul error", "{{60.0, 72.0, 84.0}, {132.0, 162.0, 192.0}, {204.0, 252.0, 300.0}}", actual.toString());
    }
    @Test
    public void MatrixDevScalar() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("T={{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}/5");
        assertEquals("Dev error", "{{0.4, 0.8, 1.2}, {1.6, 2.0, 2.4}, {2.8, 3.2, 3.6}}", actual.toString());
    }
}
