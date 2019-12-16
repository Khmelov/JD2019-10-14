package by.it.volchek.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        for (Method declaredMethod : stringClass.getDeclaredMethods()) {
            if (!Modifier.isStatic(declaredMethod.getModifiers())) {
                System.out.println(declaredMethod.getName());
            }
        }
    }
}
