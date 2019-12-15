package by.it.zabauniuk.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {

        Class<String> strClass = String.class;
        Method[] strMethod = strClass.getDeclaredMethods();

        for (Method method : strMethod) {
            if ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
                System.out.println(method.getName());
            }
        }

    }
}
