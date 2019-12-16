package by.it.volchek.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structure = Math.class;
        for( Method method : structure.getDeclaredMethods()){
            if (Modifier.isPublic(method.getModifiers())) {
                StringBuilder sb = new StringBuilder("public static ");
                sb.append(method.getReturnType())
                        .append(" ")
                        .append(method.getName())
                        .append("(")
                        .append(Arrays.toString(method.getParameterTypes()).replace("[", "")
                                .replace("]", "")
                                .replace(" ", ""))
                        .append(")");
                System.out.println(sb);
            }
        }
        for (Field field : Math.class.getFields()) {
            if (Modifier.isPublic(field.getModifiers())) {
                if (Modifier.isStatic(field.getModifiers())) {
                    System.out.println(String.valueOf(field.getType()) + ' ' + field.getName());
                }
            }
        }
    }
}
