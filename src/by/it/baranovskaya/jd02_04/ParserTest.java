package by.it.baranovskaya.jd02_04;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void testGetVar() throws Exception {
        assertEquals("Ошибка в Parser.GetVar", -123, Parser.GetVar("-123"));
    }
}