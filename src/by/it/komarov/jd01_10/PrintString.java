package by.it.komarov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {

    public static void main(String[] args) {

        Class<String> stringClassStructure = String.class;
        Method[] methodsStringClass = stringClassStructure.getDeclaredMethods();

        for (Method stringClassMetod : methodsStringClass) {
            if (!Modifier.isStatic(stringClassMetod.getModifiers())) {
                System.out.println(stringClassMetod.getName());
            }
        }
    }
}