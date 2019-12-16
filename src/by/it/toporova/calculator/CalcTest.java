package by.it.toporova.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTest {


    @Test
    public void scalarTestA1() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("A=2+5.3");
        assertEquals("Sum scalar error", "7.3",actual.toString());

    }


    @Test
    public void scalarTestA2() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("B=A*3.5");
        assertEquals("Mul scalar error", "25.55",actual.toString());

    }
    @Test
    public void  scalarTestA3() throws CalcException {
        Parser parser= new  Parser();
        Var actual = parser.evaluate("B1=B+0.11*-5");
        assertEquals("Min scalar error","25.0",actual.toString());
    }

    @Test
    public void  scalarTestA4() throws CalcException {
        Parser parser= new  Parser();
        Var actual = parser.evaluate("B2=A/2-1");
        assertEquals("Div scalar error","2.65",actual.toString());
    }

    @Test
    public void vectorTestB1() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("C=B+(A*2)");
        assertEquals("Mul vector error", "40.15",actual.toString());

    }

    @Test
    public void vectorTestB2() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("D=((C-0.15)-20)/(7-5)");
        assertEquals("Sub vector error", "10",actual.toString());

    }

    @Test
    public void vectorTestB3() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("E={2,3}*(D/2)");
        assertEquals("Sum vector error", "{10,15}",actual.toString());

    }

    @Test
    public void matrixTestС1() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("{{2,4,6},{1,2,3}}*{{2,3},{2,3},{2,3}}");
        assertEquals("Mul matrix error", "{{24.0, 36.0}, {12.0, 18.0}}",actual.toString());
            }

    @Test
    public void matrixTestС2() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("{{2,4,6},{1,2,3}}-{{2,3,2},{3,2,3}}");
        assertEquals("Sub matrix error", "{{0.0, 1.0, 4.0}, {-2.0, 0.0, 0.0}}",actual.toString());
        actual= parser.evaluate("{{2,4,6},{1,2,3}}+{{2,3,2},{3,2,3}}");
        assertEquals("Sum matrix error", "{{4.0, 7.0, 8.0}, {4.0, 4.0, 6.0}}",actual.toString());
    }
    @Test
    public void matrixTestС3() throws Exception {
        Parser parser = new Parser();
         Var actual= parser.evaluate("{{2,4,6},{1,2,3}}+{{2,3,2},{3,2,3}}");
        assertEquals("Sum matrix error", "{{4.0, 7.0, 8.0}, {4.0, 4.0, 6.0}}",actual.toString());
    }

    @Test
    public void printVarTest() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("A=9");
        assertEquals("Var print error", "9.0",actual.toString());
        actual = parser.evaluate("B={1,8,7}");
        assertEquals("Var print error", "{1.0, 8.0, 7.0}",actual.toString());
        actual = parser.evaluate("C={{1,9},{7,9}}");
        assertEquals("Var print error", "{{1.0, 9.0}, {7.0, 9.0}}",actual.toString());
    }



}