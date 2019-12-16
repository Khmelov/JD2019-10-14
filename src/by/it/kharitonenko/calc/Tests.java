package by.it.kharitonenko.calc;

import by.it.kharitonenko.calc.Vars.VarS;
import by.it.kharitonenko.calc.Vars.VarV;
import by.it.kharitonenko.calc.Vars.VarM;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    @Test
    public void parserTest() throws Exception {
        Parser parser = new Parser();
        assertEquals("ERROR: ", "7.3", parser.evaluate("A=2+5.3").toString());
        assertEquals("ERROR: ", "25.55", parser.evaluate("B=A*3.5").toString());
        assertEquals("ERROR: ", "25.0", parser.evaluate("B1=B+0.11*-5").toString());
        assertEquals("ERROR: ", "2.65", parser.evaluate("B2=A/2-1").toString());
        //Task B tests (with brackets)
        assertEquals("ERROR: ", "40.15", parser.evaluate("C=B+(A*2)").toString());
        assertEquals("ERROR: ", "10.0", parser.evaluate("D=((C-0.15)-20)/(7-5)").toString());
        assertEquals("ERROR: ", "{10.0,15.0}", parser.evaluate("E={2,3}*(D/2)").toString());
    }

    @Test
    public void testScalar() throws CalcException {
        Parser parser = new Parser();
        assertEquals("ERROR: ", "2.0", parser.evaluate("1+1").toString());
        assertEquals("ERROR: ", "0.0", parser.evaluate("1-1").toString());
        assertEquals("ERROR: ", "6.0", parser.evaluate("2*3").toString());
        assertEquals("ERROR: ", "2.0", parser.evaluate("4/2").toString());
    }

    @Test
    public void testVector() throws CalcException {
        Parser parser = new Parser();
        assertEquals("ERROR: ", "{3.0,5.0}", parser.evaluate("{1,4}+{2,1}").toString());
        assertEquals("ERROR: ", "{-1.0,0.0}", parser.evaluate("{1,1}-{2,1}").toString());
        assertEquals("ERROR: ", "{6.0,3.0,9.0}", parser.evaluate("{2,1,3}*3").toString());
        assertEquals("ERROR: ", "{3.0,1.0,1.0}", parser.evaluate("{9,3,3}/3").toString());
    }

    @Test
    public void testMatrix() throws CalcException {
        Parser parser = new Parser();
        assertEquals("ERROR: ", "{{3.0,3.0},{4.0,4.0}}", parser.evaluate("{{1,1},{2,2}}+2").toString());
        assertEquals("ERROR: ", "{{-1.0,-1.0},{0.0,0.0}}", parser.evaluate("{{1,1},{2,2}}-2").toString());
        assertEquals("ERROR: ", "{{2.0,2.0},{4.0,4.0}}", parser.evaluate("{{1,1},{2,2}}*2").toString());
        assertEquals("ERROR: ", "{{0.5,0.5},{1.0,1.0}}", parser.evaluate("{{1,1},{2,2}}/2").toString());
        assertEquals("ERROR: ", "{{2.0,2.0},{4.0,4.0}}", parser.evaluate("{{1,1},{2,2}}+{{1,1},{2,2}}").toString());
        assertEquals("ERROR: ", "{2.0,4.0}", parser.evaluate("{{1,1},{2,2}}*{2,2}").toString());
    }

    @Test
    public void testStringToVar() {
        VarS testVarS = new VarS("44");
        assertEquals("ERROR: ", "44.0", testVarS.toString());
        VarV testVarV = new VarV("{2,4,1}}");
        assertEquals("ERROR: ", "{2.0,4.0,1.0}", testVarV.toString());
        VarM testVarM = new VarM("{{2,4,1},{3,1,1}");
        assertEquals("ERROR: ", "{{2.0,4.0,1.0},{3.0,1.0,1.0}}", testVarM.toString());
    }
}