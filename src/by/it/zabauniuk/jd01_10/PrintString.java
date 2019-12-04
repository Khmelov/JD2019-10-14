package by.it.zabauniuk.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringStructure = String.class;
        Method[] methods = stringStructure.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (!Modifier.isStatic(modifiers)) {
                String name = method.getName();
                System.out.println(name);
            }
        }
    }


}
