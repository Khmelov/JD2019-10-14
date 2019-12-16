package by.it.protsko.calc;

import by.it.protsko.calc.lang_operations.ResurceManager;
import by.it.protsko.calc.lang_operations.TestMessages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCalc {

    @Before
    public void load() {
        Var.loadCalcVariable();
    }

    @After
    public void save() {
        Var.saveCalcVariable();
    }

    @Test(timeout = 2000)
    public void TestScalar_Add() throws CalcException {
        Parser parser = new Parser();
        Var actual = parser.calc("A=2+5.3");
        assertEquals(ResurceManager.INSTANSE.getMessage(TestMessages.ERR_ASSERT_VALUE), "7.3", actual.toString());
    }

    @Test(timeout = 2000)
    public void TestScalar_Sub() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.calc("B2=A/2-1");
        assertEquals(ResurceManager.INSTANSE.getMessage(TestMessages.ERR_ASSERT_VALUE), "2.65", actual.toString());
    }

    @Test(timeout = 2000)
    public void TestScalar_Mul() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.calc("B=A*3.5");
        assertEquals(ResurceManager.INSTANSE.getMessage(TestMessages.ERR_ASSERT_VALUE), "25.55", actual.toString());
    }

    @Test(timeout = 2000)
    public void TestScalar_Div() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.calc("A/2");
        assertEquals(ResurceManager.INSTANSE.getMessage(TestMessages.ERR_ASSERT_VALUE), "3.65", actual.toString());
    }

    @Test(timeout = 2000, expected = CalcException.class)
    public void TestVector_Add() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.calc("A={2,3,4}+5");
        assertEquals(ResurceManager.INSTANSE.getMessage(TestMessages.ERR_ASSERT_VALUE), "{7.0, 8.0, 9.0}", actual.toString());
        Var actual1 = parser.calc("B={2,3,4}+{1,2,3}");
        assertEquals(ResurceManager.INSTANSE.getMessage(TestMessages.ERR_ASSERT_VALUE), "{3.0, 5.0, 7.0}", actual1.toString());
        Var actual2 = parser.calc("C=A+B");
        assertEquals(ResurceManager.INSTANSE.getMessage(TestMessages.ERR_ASSERT_VALUE), "{10.0, 13.0, 16.0}", actual2.toString());
        Var actual3 = parser.calc("A={2,3,4}+{1,2,3,4}");
    }

    @Test(timeout = 2000, expected = CalcException.class)
    public void TestVector_Sub() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.calc("A={2,3,4}-5");
        assertEquals(ResurceManager.INSTANSE.getMessage(TestMessages.ERR_ASSERT_VALUE), "{-3.0, -2.0, -1.0}", actual.toString());
        Var actual1 = parser.calc("B=A-{10,9,8}");
        assertEquals(ResurceManager.INSTANSE.getMessage(TestMessages.ERR_ASSERT_VALUE), "{-13.0, -11.0, -9.0}", actual1.toString());
        Var actual2 = parser.calc("B=A-18");
        assertEquals(ResurceManager.INSTANSE.getMessage(TestMessages.ERR_ASSERT_VALUE), "{-21.0, -20.0, -19.0}", actual2.toString());
        Var actual3 = parser.calc("{2,3,4}-{1,2,3}-{0,6,9}");
        assertEquals(ResurceManager.INSTANSE.getMessage(TestMessages.ERR_ASSERT_VALUE), "{1.0, -5.0, -8.0}", actual3.toString());
        Var actual4 = parser.calc("{2,3,4}-{1,2,3,8}-{0,6,9}");
    }

    @Test(timeout = 2000, expected = CalcException.class)
    public void TestVector_Mul() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.calc("A={2,3,4}*5");
        assertEquals(ResurceManager.INSTANSE.getMessage(TestMessages.ERR_ASSERT_VALUE), "{10.0, 15.0, 20.0}", actual.toString());
        Var actual1 = parser.calc("B=A*A");
        assertEquals(ResurceManager.INSTANSE.getMessage(TestMessages.ERR_ASSERT_VALUE), "725.0", actual1.toString());
        Var actual2 = parser.calc("E=B*3");
        assertEquals(ResurceManager.INSTANSE.getMessage(TestMessages.ERR_ASSERT_VALUE), "2175.0", actual2.toString());
        Var actual3 = parser.calc("{2,3,4}*{1,2,3}*{1,6,9}");
        assertEquals(ResurceManager.INSTANSE.getMessage(TestMessages.ERR_ASSERT_VALUE), "{20.0, 120.0, 180.0}", actual3.toString());
        Var actual4 = parser.calc("{2,3,4}*{1,2}");
    }

    @Test(timeout = 2000, expected = CalcException.class)
    public void TestVector_Div() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.calc("A={2,3,4}/5");
        assertEquals(ResurceManager.INSTANSE.getMessage(TestMessages.ERR_ASSERT_VALUE), "{0.4, 0.6, 0.8}", actual.toString());
        Var actual1 = parser.calc("B=A*2/4");
        assertEquals(ResurceManager.INSTANSE.getMessage(TestMessages.ERR_ASSERT_VALUE), "{0.2, 0.3, 0.4}", actual1.toString());
        Var actual2 = parser.calc("C=A/0");                                                         //ERROR:Деление на ноль
        Var actual3 = parser.calc("A/B");                                                           //ERROR: Операция деления векторов невозможна
        Var actual4 = parser.calc("{2,3,4}*{1,2}");
    }

    @Test(timeout = 2000, expected = CalcException.class)
    public void TestMarix_Add() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.calc("A={{1,2,3,4},{5,6,7,8}} + {{2,5,8,9},{14,15,20,13}}");
        assertEquals("{{3.0, 7.0, 11.0, 13.0}, {19.0, 21.0, 27.0, 21.0}}", actual.toString());
        Var actual1 = parser.calc("B=A+A");
        assertEquals("{{6.0, 14.0, 22.0, 26.0}, {38.0, 42.0, 54.0, 42.0}}", actual1.toString());
        Var actual2 = parser.calc("B=B+15");
        assertEquals("{{21.0, 29.0, 37.0, 41.0}, {53.0, 57.0, 69.0, 57.0}}", actual2.toString());
        Var actual3 = parser.calc("{{1,2},{8,3}}+{{2,3,3},{2,3,3}}");                           //ERROR: Сложение матриц невозможно - размеры не совпадают
        Var actual4 = parser.calc("{{1,2},{8,3}} + {2,3,3}");                                   //ERROR: Невозможно прибавить вектор к матрице
    }

    @Test(timeout = 2000, expected = CalcException.class)
    public void TestMatrix_Sub() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.calc("A={{1,2,3,4},{5,6,7,8}} - {{2,5,8,9},{14,15,20,13}}");
        assertEquals("{{-1.0, -3.0, -5.0, -5.0}, {-9.0, -9.0, -13.0, -5.0}}", actual.toString());
        Var actual1 = parser.calc("B=A-A");
        assertEquals("{{0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0}}", actual1.toString());
        Var actual2 = parser.calc("B=B-15");
        assertEquals("{{-15.0, -15.0, -15.0, -15.0}, {-15.0, -15.0, -15.0, -15.0}}", actual2.toString());
        Var actual3 = parser.calc("{{1,2},{8,3}}-{{2,3,3},{2,3,3}}");                           //ERROR: Вычитание матриц невозможно - размеры не совпадают
        Var actual4 = parser.calc("{{1,2},{8,3}} - {2,3,3}");                                   //ERROR: Невозможно вычесть вектор из матрицы

    }

    @Test(timeout = 2000, expected = CalcException.class)
    public void TestMatrix_Mul() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.calc("A={{1,2,3,4},{5,6,7,8}} * {{2,5,8,9},{14,15,20,13}}");        //ERROR: Умножение матриц невозможно - размеры не совпадают
        Var actual1 = parser.calc("A={{1,2},{8,3}}*{{1,2},{8,3}}");
        assertEquals("{{17.0, 8.0}, {32.0, 25.0}}", actual1.toString());
        Var actual2 = parser.calc("{{1,2},{8,3}}*{{1,2},{8,3}} * 3");
        assertEquals("{{51.0, 24.0}, {96.0, 75.0}}", actual2.toString());
        Var actual3 = parser.calc("{{1,2},{8,3}}*{1,2}");
        assertEquals("{5.0, 14.0}", actual3.toString());
        Var actual4 = parser.calc("{{1,2},{8,3},{2,3,3}}*{1,2,3}");                              //ERROR: Умножение матрицы на вектор невозможно - не совпадают размеры
    }

    @Test(timeout = 2000, expected = CalcException.class)
    public void TestMatrix_Div() throws Exception {
        Parser parser = new Parser();
        Var actual = parser.calc("A={{1,2,3,4},{5,6,7,8}} / {{2,5,8,9},{14,15,20,13}}");        //ERROR: Операция деления матриц невозможна
        Var actual2 = parser.calc("A={{1,2},{8,3}} / 2");
        assertEquals("{{0.5, 1.0}, {4.0, 1.5}}", actual2.toString());
        Var actual1 = parser.calc("A={{1,2},{8,3}}/{1,2}");                                     //ERROR: Операция деления матрицы невозможна
        Var actual3 = parser.calc("A={{1,2},{8,3},{1,2},{8,3}} / 0");                          //ERROR: Деление на ноль
    }
}


