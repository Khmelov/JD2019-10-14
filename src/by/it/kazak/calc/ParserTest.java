package by.it.kazak.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void A() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("A=2+5.3");
        assertEquals("Sum error", "7.3", actual.toString());
        System.out.println(
                "Операция: A=2+5.3" +
                        "\nПолучено значение: " + actual +
                        "\nОжидаемое значение: 7.3");
    }

    @Test
    public void B() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("B=A*3.5");
        assertEquals("Sum error", "25.55", actual.toString());
        System.out.println(
                "Операция: B=A*3.5" +
                        "\nПолучено значение: " + actual +
                        "\nОжидаемое значение: 25.55");
    }

    @Test
    public void B1() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("B1=B+0.11*-5");
        assertEquals("Sum error", "25.0", actual.toString());
        System.out.println(
                "Операция: B1=B+0.11*-5" +
                        "\nПолучено значение: " + actual +
                        "\nОжидаемое значение: 25.0");
    }

    @Test
    public void B2() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("B2=A/2-1");
        assertEquals("Sum error", "2.65", actual.toString());
        System.out.println(
                "Операция: B2=A/2-1" +
                        "\nПолучено значение: " + actual +
                        "\nОжидаемое значение: 2.65");
    }

    @Test
    public void C() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("C=B+(A*2)");
        assertEquals("Sum error", "40.15", actual.toString());
        System.out.println(
                "Операция: C=B+(A*2)" +
                        "\nПолучено значение: " + actual +
                        "\nОжидаемое значение: 40.15");
    }

    @Test
    public void D() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("D=((C-0.15)-20)/(7-5)");
        assertEquals("Sum error", "10.0", actual.toString());
        System.out.println(
                "Операция: D=((C-0.15)-20)/(7-5)" +
                        "\nПолучено значение: " + actual +
                        "\nОжидаемое значение: 10.0");
    }

    @Test
    public void E() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.evaluate("E={2,3}*(D/2)");
        assertEquals("Sum error", "{10.0, 15.0}", actual.toString());
        System.out.println(
                "Операция: E={2,3}*(D/2)" +
                        "\nПолучено значение: " + actual +
                        "\nОжидаемое значение: {10.0, 15.0}");
    }
}