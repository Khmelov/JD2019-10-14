package by.it.kazak.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> strMath = Math.class;
        Method[] methods = strMath.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                String sb = "public " + "static " + method.getReturnType() + " " + method.getName() + "(" +
                        Arrays.toString(method.getParameterTypes()).replace("[", "")
                                .replace("]", "").replace(" ", "") +
                        ")";
                System.out.println(sb);
            }
        }
        Field[] fields = Math.class.getFields();
        for (Field field : fields) {
            if (Modifier.isPublic(field.getModifiers())) {
                if (Modifier.isStatic(field.getModifiers())) {
                    System.out.println(String.valueOf(field.getType()) + ' ' + field.getName());
                }
            }
        }
    }
}