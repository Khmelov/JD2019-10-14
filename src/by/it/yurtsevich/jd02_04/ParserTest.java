package by.it.yurtsevich.jd02_04;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    private static Parser parser;

@BeforeClass
public static void initParser(){
    parser = new Parser();
}
    @Test

    public void checkCreationOfVar() throws CalcException {
        String expression="A=2+2*2";
        String expected="6.0";
        parser.calculate(expression);
        Var var=Var.createVar("A");
        assertEquals(expected, var.toString());
    }
    @Test
    public void checkSimpleCalc() throws CalcException{
        String expression="A=3*3+1";
        String actual=parser.calculate(expression).toString();
        String expected="10.0";
        assertEquals(expected,actual);
    }

    @Test
    public void checkScalarAddScalar() throws CalcException {
        String expression="A=2+5.3";
        String actual=parser.calculate(expression).toString();
        String expected="7.3";
        assertEquals(expected,actual);
    }
    @Test
    public void checkScalarSubScalar() throws CalcException {
        String expression="A=100-89";
        String actual=parser.calculate(expression).toString();
        String expected="11.0";
        assertEquals(expected,actual);
    }

    @Test
    public void checkScalarDivScalar() throws CalcException {
        String expression="A=1440/40";
        String actual=parser.calculate(expression).toString();
        String expected="36.0";
        assertEquals(expected,actual);
    }

    @Test
    public void checkVectorAddScalar() throws CalcException {
        Var var = parser.calculate("A={1,2}+3");
        String expected = "{4.0, 5.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }

//    @Test
//    public void checkOperationWithBrackets() throws Exception{
//        Var varA = parser.calculate("A=2+5.3");
//        Var varB = parser.calculate("B="+varA.toString()+"*3.5");
//        Var varC = parser.calculate("C="+varB.toString()+"("+varA.toString()+"*2)");
//        Var varD = parser.calculate("D=(("+varC.toString()+"-0.15)-20)/(7-5)");
//        Var varE = parser.calculate("E={2,3}*("+varD.toString()+"/2)");
//        String expected = "{10,15}";
//        String actual = varE.toString();
//        assertEquals(expected, actual);
//    }

    @Test
    public void checkVectorMultipleScalar() throws CalcException {
        Var var = parser.calculate("A={3,4}+5*6-7");
        String expected = "{26.0, 27.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }
    @Test
    public void checkVectorSubScalar() throws CalcException {
        Var var = parser.calculate("A={2,3}-1");
        String actual = var.toString();
        String expected = "{1.0, 2.0}";
        assertEquals(expected, actual);
    }

    @Test
    public void checkVectorAddVector() throws CalcException {
        String expression = "A={99,2,7}+{-45,25,53}";
        String expected = "{54.0, 27.0, 60.0}";
        Parser parser = new Parser();
        String actual = parser.calculate(expression).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void checkVectorMulVector() throws CalcException{
        String expression = "A={4.9,7.3,2.1}*{3,8,5}";
        String expected = "83.6";
        Parser parser = new Parser();
        String actual = parser.calculate(expression).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void checkVectorDivVector() throws CalcException {
        String expression = "A={7,7,7}/4";
        String expected = "{1.75, 1.75, 1.75}";
        Parser parser = new Parser();
        String actual = parser.calculate(expression).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void checkVectorSubVector() throws CalcException {
        Var var = parser.calculate("A={3,4}-{1,2}");
        String actual = var.toString();
        String expected = "{2.0, 2.0}";
        assertEquals(expected, actual);
    }

    @Test
    public void checkSimpleExpressionMatrix() throws CalcException {
        Var var = parser.calculate("A={{2, 3},{2, 3}}+{{1, 2},{3, 4}}");
        String expected = "{{3.0, 5.0}, {5.0, 7.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }
    @Test
    public void checkMatrixMulMatrix() throws CalcException {
        Var var = parser.calculate("A={{1,2},{3,4}}*{{1,2},{3,4}}");
        String actual = var.toString();
        String expected = "{{7.0, 10.0}, {15.0, 22.0}}";
        assertEquals(expected, actual);
    }

    @Test
    public void checkMatrixSubMatrix() throws CalcException {
        Var var = parser.calculate("A={{2,3},{4,5}}-{{1,2},{3,4}}");
        String actual = var.toString();
        String expected = "{{1.0, 1.0}, {1.0, 1.0}}";
        assertEquals(expected, actual);
    }
    @Test
    public void checkMatrixDivScalar() throws CalcException {
        Var var = parser.calculate("A={{54.9,28.9},{37,88}}/4");
        String actual = var.toString();
        String expected = "{{13.725, 7.225}, {9.25, 22.0}}";
        assertEquals(expected, actual);
    }
    @Test
    public void checkMatrixAddMatrix() throws CalcException {
        Var var = parser.calculate("A={{1,3},{7,5}}+{{7,2},{3,4}}");
        String actual = var.toString();
        String expected = "{{8.0, 5.0}, {10.0, 9.0}}";
        assertEquals(expected, actual);
    }

    @Test
    public void checkMatrixToString() throws CalcException {
        Var matrix = Var.createVar("{{3,2,1},{7,9,8},{4,5,6}}");
        String expected = "{{3.0, 2.0, 1.0}, {7.0, 9.0, 8.0}, {4.0, 5.0, 6.0}}";
        String actual = matrix.toString();
        assertEquals(expected,actual);
    }
}