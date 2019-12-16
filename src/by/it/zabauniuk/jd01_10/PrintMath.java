package by.it.zabauniuk.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {

        Class<Math> mathClass = Math.class;
        Method[] mathMethods = mathClass.getDeclaredMethods();

        for (Method mathMethod : mathMethods) {
            if ((mathMethod.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {

                StringBuilder line = new StringBuilder();
                int modifiers = mathMethod.getModifiers();

                if (Modifier.isPublic(modifiers)) line.append("public ");
                if (Modifier.isStatic(modifiers)) line.append("static ");
                line.append(mathMethod.getReturnType()).append(" ");
                line.append(mathMethod.getName()).append("(");

                Class<?>[] parameterTypes = mathMethod.getParameterTypes();
                String divider = "";
                for (Class<?> parameterType : parameterTypes) {
                    line.append(divider).append(parameterType.getSimpleName());
                    divider = ",";
                }
                line.append(")");
                System.out.println(line);
            }
        }

        Field[] mathFields = mathClass.getDeclaredFields();
        for (Field mathField : mathFields) {
            if ((mathField.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                StringBuilder line = new StringBuilder();
                int modifiers = mathField.getModifiers();
                if (Modifier.isPublic(modifiers)) line.append("public ");
                if (Modifier.isStatic(modifiers)) line.append("static ");
                line.append(mathField.getType()).append(" ");
                line.append(mathField.getName());
                System.out.println(line);
            }
        }
    }

}