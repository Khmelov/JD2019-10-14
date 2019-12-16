package by.it.baranovskaya.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static java.lang.reflect.Modifier.isPublic;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] declaredMethod = mathClass.getDeclaredMethods();
        for (Method method : declaredMethod) {
            if (isPublic(method.getModifiers())) {
                String modifier = Modifier.toString(method.getModifiers());
                String s = Arrays.toString(method.getParameters());
                s = s.replaceAll("\\[", "(");
                s = s.replaceAll("]", ")");
                s = s.replaceAll("[arg\\d?\\s]", "");
                s = s.replaceAll("flot", "float");
                s = s.replaceAll("lon", "long");
                System.out.println(modifier + " " + method.getReturnType() + " " + method.getName() + s);
            }
        }
        Field[] declaredFields = Math.class.getDeclaredFields();
        for (Field field : declaredFields) {
            if(isPublic(field.getModifiers())) {
                String name = field.getName();
                String type = field.getType().getName();
                System.out.println(type + " " + name);
            }
        }
    }
}
